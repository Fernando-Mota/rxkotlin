package zipoperator

import java.util.*


data class ItemDB (val id: String = UUID.randomUUID().toString(), val description: String, val quantity: Int, val subcategoriaId: String)