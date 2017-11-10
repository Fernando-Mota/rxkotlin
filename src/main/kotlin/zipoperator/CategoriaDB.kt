package zipoperator

import java.util.*

data class CategoriaDB(val id: String = UUID.randomUUID().toString(), val description: String, val subcategoriasDB: MutableList<SubcategoriaDB> = mutableListOf())