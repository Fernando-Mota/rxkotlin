package zipoperator

import java.util.*

data class SubcategoriaDB(val id: String = UUID.randomUUID().toString(), val categoriaDBId: String, val description: String, val produtos: MutableList<ItemDB>)