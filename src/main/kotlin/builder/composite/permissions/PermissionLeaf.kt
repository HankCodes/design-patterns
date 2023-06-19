package builder.composite.permissions

import builder.composite.permissions.contracts.Component


class PermissionLeaf(private val permission: Permission) : Component {
    override fun permission(): String {
       return permission.getPermission()
    }
}