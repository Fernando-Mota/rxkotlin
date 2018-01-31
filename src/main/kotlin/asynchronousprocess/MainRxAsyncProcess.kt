package asynchronousprocess

import hu.akarnokd.rxjava2.schedulers.BlockingScheduler
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers


class Todo(description: String) {

    val description: String = description
}


fun main(args: Array<String>) {

    var todos = arrayListOf(Todo(description = "Descrição 1"), Todo(description = "Descrição 2"), Todo(description = "Descrição 3"))

    var descriptions = arrayListOf<String>("Descricao 11", "Descricao 22", "Descricao 33", "Descricao 44", "Descricao 55")

    var scheduler2 = BlockingScheduler()

    scheduler2.execute {
    Observable.merge(Observable.just(todos), Observable.just(descriptions)
                                                                .flatMap { descriptions -> Observable.fromIterable(descriptions) }
                                                                .map { description -> Todo(description = description) }
                                                                .toList()
                                                                .toObservable())
            .flatMap { list -> println(list.size)
                Observable.fromIterable(list) }
            .subscribeOn(Schedulers.computation())
            .map{ todo -> todo.description }
            .filter { s -> println(Thread.currentThread().name); s.contains("1") || s.contains("3") }
            .map {s -> Todo(description = s) }
            .toList()
            .toObservable()
            .observeOn(scheduler2)
            .flatMap { todos -> Observable.fromIterable(todos) }
            .subscribe(
                    { todo -> Observable.just(todo).subscribe { todo -> println(todo.description)
                    println(Thread.currentThread().name)} },
                    {t -> println("Deu probleminha")},
                    { println("Cabou!")}
            )
    }
    Thread.sleep(30000)
    println(Thread.currentThread().name)
}
