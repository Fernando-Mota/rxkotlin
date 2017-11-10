package zipoperator

data class Item (val id: String, val description: String, val quantity: Int, val subcategoriaId: String) {

    override fun toString(): String {
        return "        zipoperator.Item id: ${this.id} description: ${this.description} quantity: ${this.quantity} subcategoria: ${this.subcategoriaId}\n"
    }

}

