package zipoperator

import hu.akarnokd.rxjava2.schedulers.BlockingScheduler
import io.reactivex.Observable
import io.reactivex.functions.BiFunction
import io.reactivex.schedulers.Schedulers

fun main(args: Array<String>) {

    val categorias = mutableListOf<Categoria>()

    val dataBase = DataBase()


    var mainThreadScheduler = BlockingScheduler()

    mainThreadScheduler.execute {

        dataBase.getCategorias()
                .flatMap {
                    categorias ->
                    Observable.fromIterable(categorias)
                }
                .flatMap {
                    categoriaDB ->
                    Observable.zip(Observable.just(Categoria(id = categoriaDB.id, description = categoriaDB.description, subcategorias = mutableListOf())),
                            dataBase.getSubCategoriaByCategoriaId(categoriaDB.id).flatMap {
                                subcategoriasDB -> Observable.fromIterable(subcategoriasDB)
                            }.flatMap { subCategoriaDB ->
                                Observable.zip(Observable.just(Subcategoria(id = subCategoriaDB.id, categoriaDBId = subCategoriaDB.categoriaDBId, description = subCategoriaDB.description, produtos = mutableListOf())),
                                    dataBase.getProdutoBySubcategoriaId(subcategoriaId = subCategoriaDB.id).flatMap {
                                        produtosDB -> Observable.fromIterable(produtosDB)
                                    }.map { produtoDB -> Item(id = produtoDB.id, description = produtoDB.description, subcategoriaId = produtoDB.subcategoriaId, quantity = produtoDB.quantity) }.toList().toObservable(),
                                BiFunction<Subcategoria, MutableList<Item>, Subcategoria> {
                                    subcategoria, items ->
                                    subcategoria.produtos.addAll(items)
                                    subcategoria
                                })
                            }.toList().toObservable(),
                            BiFunction<Categoria, MutableList<Subcategoria>, Categoria> {

                        categoria, subcategorias ->
                                categoria.subcategorias.addAll(subcategorias)
                        categoria
                    })
                }
                .subscribeOn(Schedulers.computation())
                .observeOn(mainThreadScheduler)

                .subscribe(

                {
                    categoria ->
                    println(categoria.toString())
                    categorias.add(categoria)
                },
                {
                    e -> e.printStackTrace()
                },
                {
                    print("acabou, categorias: ${categorias.size}")
                })
    }

}