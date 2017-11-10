package zipoperator

import io.reactivex.Observable

class DataBase {

    val items = mutableListOf(
            ItemDB(description = "zipoperator.Item 1", quantity = 2, subcategoriaId = "7B212E8D-811A-4FBC-AD42-A7A6AC6BBE32"),
            ItemDB(description = "zipoperator.Item 2", quantity = 3, subcategoriaId = "7B212E8D-811A-4FBC-AD42-A7A6AC6BBE32"),
            ItemDB(description = "zipoperator.Item 3", quantity = 4, subcategoriaId = "7B212E8D-811A-4FBC-AD42-A7A6AC6BBE32"),
            ItemDB(description = "zipoperator.Item 4", quantity = 5, subcategoriaId = "7B212E8D-811A-4FBC-AD42-A7A6AC6BBE32"),
            ItemDB(description = "zipoperator.Item 5", quantity = 2, subcategoriaId = "F9EE35EB-5C78-4DBD-A305-2CCBF3E45E43"),
            ItemDB(description = "zipoperator.Item 6", quantity = 7, subcategoriaId = "F9EE35EB-5C78-4DBD-A305-2CCBF3E45E43"),
            ItemDB(description = "zipoperator.Item 7", quantity = 1, subcategoriaId = "F9EE35EB-5C78-4DBD-A305-2CCBF3E45E43"),
            ItemDB(description = "zipoperator.Item 8", quantity = 8, subcategoriaId = "F9EE35EB-5C78-4DBD-A305-2CCBF3E45E43"),
            ItemDB(description = "zipoperator.Item 9", quantity = 9, subcategoriaId = "F9EE35EB-5C78-4DBD-A305-2CCBF3E45E43"),
            ItemDB(description = "zipoperator.Item 10", quantity = 12, subcategoriaId = "7C6B0318-4876-4F3F-B865-676504F52D39"),
            ItemDB(description = "zipoperator.Item 11", quantity = 6, subcategoriaId = "7C6B0318-4876-4F3F-B865-676504F52D39"),
            ItemDB(description = "zipoperator.Item 12", quantity = 22, subcategoriaId = "7C6B0318-4876-4F3F-B865-676504F52D39"),
            ItemDB(description = "zipoperator.Item 13", quantity = 24, subcategoriaId = "7C6B0318-4876-4F3F-B865-676504F52D39"),
            ItemDB(description = "zipoperator.Item 14", quantity = 8, subcategoriaId = "911C3101-3217-481E-9500-943435BCAAD8"),
            ItemDB(description = "zipoperator.Item 15", quantity = 3, subcategoriaId = "911C3101-3217-481E-9500-943435BCAAD8"),
            ItemDB(description = "zipoperator.Item 16", quantity = 33, subcategoriaId = "911C3101-3217-481E-9500-943435BCAAD8"),
            ItemDB(description = "zipoperator.Item 17", quantity = 79, subcategoriaId = "911C3101-3217-481E-9500-943435BCAAD8"),
            ItemDB(description = "zipoperator.Item 18", quantity = 23, subcategoriaId = "2E3125F8-1C38-4163-9DEB-24176CE9FF60"),
            ItemDB(description = "zipoperator.Item 19", quantity = 56, subcategoriaId = "2E3125F8-1C38-4163-9DEB-24176CE9FF60"),
            ItemDB(description = "zipoperator.Item 20", quantity = 60, subcategoriaId = "2E3125F8-1C38-4163-9DEB-24176CE9FF60")
    )


    val subcategorias = mutableListOf<SubcategoriaDB>(
            SubcategoriaDB(id = "7B212E8D-811A-4FBC-AD42-A7A6AC6BBE32", categoriaDBId = "1855FEBE-810C-4D86-BB92-BA2957272654", description = "Sub 1", produtos = mutableListOf()),
            SubcategoriaDB(id = "F9EE35EB-5C78-4DBD-A305-2CCBF3E45E43", categoriaDBId = "D0893A29-D07B-4FA4-A660-1A5F31EF12B8", description = "Sub 2", produtos = mutableListOf()),
            SubcategoriaDB(id = "7C6B0318-4876-4F3F-B865-676504F52D39", categoriaDBId = "BD380F7B-A978-4E3B-B67B-78EC31638B45", description = "Sub 3", produtos = mutableListOf()),
            SubcategoriaDB(id = "911C3101-3217-481E-9500-943435BCAAD8", categoriaDBId = "02339D2E-20FE-4C1F-A031-6485DD948AE2", description = "Sub 4", produtos = mutableListOf()),
            SubcategoriaDB(id = "2E3125F8-1C38-4163-9DEB-24176CE9FF60", categoriaDBId = "6A426B7B-94CB-47ED-B883-CD2064931DD9", description = "Sub 5", produtos = mutableListOf())
    )

    val categorias = mutableListOf<CategoriaDB>(
            CategoriaDB(id = "1855FEBE-810C-4D86-BB92-BA2957272654", description = "categoria 1"),
            CategoriaDB(id = "D0893A29-D07B-4FA4-A660-1A5F31EF12B8", description = "categoria 2"),
            CategoriaDB(id = "BD380F7B-A978-4E3B-B67B-78EC31638B45", description = "categoria 3"),
            CategoriaDB(id = "6A426B7B-94CB-47ED-B883-CD2064931DD9", description = "categoria 4")
    )

    fun getSubCategoriaByCategoriaId(categoriaId: String): Observable<MutableList<SubcategoriaDB>> {
        val result = mutableListOf<SubcategoriaDB>()
        for (subcategoriaDb in subcategorias) {
            if (categoriaId.equals(subcategoriaDb.categoriaDBId)) {
                result.add(subcategoriaDb)
            }
        }
        return Observable.just(result)
    }

    fun getProdutoBySubcategoriaId(subcategoriaId: String): Observable<MutableList<ItemDB>> {
        val result = mutableListOf<ItemDB>()
        for (itemDb in items) {
            if (subcategoriaId.equals(itemDb.subcategoriaId)) {
                result.add(itemDb)
            }
        }
        return Observable.just(result)
    }

    fun getCategorias(): Observable<MutableList<CategoriaDB>> {
        val result = mutableListOf<CategoriaDB>()
        for (categoriaDB in categorias) {
            result.add(categoriaDB)
        }
        return Observable.just(result)
    }
}