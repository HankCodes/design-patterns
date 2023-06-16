package permissions

import permissions.contracts.Component

class RoleComposite(private val name: String) : Component {
    private val children = mutableListOf<Component>()

    fun add(component: Component) {
        children.add(component)
    }

    override fun permission(): String = children.joinToString(delimiter) {
            it.permission()
        }
}