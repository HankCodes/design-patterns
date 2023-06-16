package permissions.contracts

interface Component {
    val delimiter: String
        get() = ", "
    fun permission(): String
}