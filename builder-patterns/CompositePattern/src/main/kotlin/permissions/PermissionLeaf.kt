package permissions

import permissions.contracts.Component

class PermissionLeaf(private val permission: Permission) : Component {
    override fun permission(): String {
       return permission.getPermission()
    }
}