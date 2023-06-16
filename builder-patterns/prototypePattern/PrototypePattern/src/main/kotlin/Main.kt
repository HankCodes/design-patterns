
data class PrototypePatternDataClass(
    val name: String,
    val age: Int,
    val address: String,
    val contact: String,
    val id: Int,
)

interface ModifiableCloneable<T>  {
    fun clone(vararg args: Array<Any> ): T
}

class PrototypePatternClass (
    val name: String? = null,
    val age: Int? = null,
    val address: String? = null,
    val contact: String? = null,
    val id: Int? = null,
) : ModifiableCloneable<PrototypePatternClass> {

    override fun clone(vararg args: Any): PrototypePatternClass {
                var name = name
                var age = age
                var address = address
                var contact = contact
                var id = id

                // Update the cloned object with any named arguments
                for ((key, value) in args) {
                    when (key) {
                        "name" -> name = value as String
                        "age" -> age = value as Int
                        "address" -> address = value as String
                        "contact" -> contact = value as String
                        "id" -> id = value as Int
                        else -> throw IllegalArgumentException("Unknown argument: $key")
                    }
                }

                return PrototypePatternClass(
                    name = name,
                    age = age,
                    address = address,
                    contact = contact,
                    id = id,
                )
    }
}

fun prototypePatternExample() {
    val prototypePattern = PrototypePatternDataClass(
        name = "John",
        age = 30,
        address = "123 Main St",
        contact = "1234567890",
        id = 123456,
    )

    val prototypePattern2 = prototypePattern.copy(
        name = "Alice",
        age = 31,
        id = 3872493,
    )

    val prototypePattern3 = PrototypePatternClass(
        name = "John",
        age = 30,
        address = "123 Main St",
        contact = "1234567890",
        id = 123456,
    )

    val prototypePattern4 = prototypePattern3.clone(
        "Alice",
        31,
        3872493,
    )

    println("prototypePattern: $prototypePattern")
    println("prototypePattern2: $prototypePattern2")
}


fun main(args: Array<String>) {
    println("Hello World!")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")
    prototypePatternExample()

    val rectangle = Rectangle(10, 20)
    val clonedRectangle = rectangle.clone(rectangle.getWidth(), rectangle.getHeight())

    println("Original rectangle: ${rectangle.getWidth()} x ${rectangle.getHeight()}")
    println("Cloned rectangle: ${clonedRectangle.getWidth()} x ${clonedRectangle.getHeight()}")

    val updatedClonedRectangle = clonedRectangle.clone(15, 25)

    println("Updated cloned rectangle: ${updatedClonedRectangle.getWidth()} x ${updatedClonedRectangle.getHeight()}")
}

