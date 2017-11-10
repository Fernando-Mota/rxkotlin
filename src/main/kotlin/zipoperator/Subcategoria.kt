package zipoperator

import java.util.*

data class Subcategoria(val id: String = UUID.randomUUID().toString(), val categoriaDBId: String, val description: String, val produtos: MutableList<Item> = mutableListOf()) {

    override fun toString(): String {
        val builder = StringBuilder()
        builder.append("    zipoperator.Subcategoria id: ${this.id} descrption: ${this.description} categoriaId: ${this.categoriaDBId}\n")
        for (item in this.produtos) {
            builder.append(item.toString())
        }
        return builder.toString()
    }

}