package zipoperator

import java.util.*

data class Categoria(val id: String = UUID.randomUUID().toString(), val description: String, val subcategorias: MutableList<Subcategoria> = mutableListOf()) {
    override fun toString(): String {
        val builder = StringBuilder()
        builder.append("zipoperator.Categoria id: ${this.id} descrption: ${this.description}\n")
        for (item in this.subcategorias) {
            builder.append(item.toString())
        }
        return builder.toString()
    }
}