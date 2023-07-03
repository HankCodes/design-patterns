package structural.composite

import structural.composite.permissions.*


fun createFilePermissions(): List<Permission> {
    val fileCreatePermission = PermissionBuilder()
        .entities(listOf(Entity.FILE))
        .resourceScope(ResourceScope.ALL)
        .baseOperation(BaseOperation.CREATE)
        .build()
    val fileReadPermission = PermissionBuilder()
        .entities(listOf(Entity.FILE))
        .resourceScope(ResourceScope.ALL)
        .baseOperation(BaseOperation.READ)
        .build()
    val fileUpdatePermission = PermissionBuilder()
        .entities(listOf(Entity.FILE))
        .resourceScope(ResourceScope.ALL)
        .baseOperation(BaseOperation.UPDATE)
        .build()
    val fileDeletePermission = PermissionBuilder()
        .entities(listOf(Entity.FILE))
        .resourceScope(ResourceScope.ALL)
        .baseOperation(BaseOperation.DELETE)
        .build()

    return listOf(
        fileCreatePermission,
        fileReadPermission,
        fileUpdatePermission,
        fileDeletePermission,
    )
}

fun createProductPermissions(): List<Permission> {
    val createPermission = PermissionBuilder()
        .entities(listOf(Entity.PRODUCT))
        .resourceScope(ResourceScope.ALL)
        .baseOperation(BaseOperation.CREATE)
        .build()
    val readPermission = PermissionBuilder()
        .entities(listOf(Entity.PRODUCT))
        .resourceScope(ResourceScope.ALL)
        .baseOperation(BaseOperation.READ)
        .build()
    val updatePermission = PermissionBuilder()
        .entities(listOf(Entity.PRODUCT))
        .resourceScope(ResourceScope.ALL)
        .baseOperation(BaseOperation.UPDATE)
        .build()
    val deletePermission = PermissionBuilder()
        .entities(listOf(Entity.PRODUCT))
        .resourceScope(ResourceScope.ALL)
        .baseOperation(BaseOperation.DELETE)
        .build()

    return listOf(
        createPermission,
        readPermission,
        updatePermission,
        deletePermission,
    )
}


fun run() {

    val adminRoleFile = RoleComposite("FileAdmin")
    createFilePermissions()
        .map { PermissionLeaf(it) }
        .forEach { adminRoleFile.add(it) }

    val adminRoleProduct = RoleComposite("ProductAdmin")
    createProductPermissions()
        .map { PermissionLeaf(it) }
        .forEach { adminRoleProduct.add(it) }

    val globalAdminRole = RoleComposite("GlobalAdmin")
    globalAdminRole.add(adminRoleFile)
    globalAdminRole.add(adminRoleProduct)
    globalAdminRole.add(
        PermissionLeaf(
            PermissionBuilder()
                .entities(listOf(Entity.DEPARTMENT, Entity.EMPLOYEE))
                .resourceScope(ResourceScope.ALL)
                .baseOperation(BaseOperation.CREATE)
                .build()
        )
    )

    val memberRole = RoleComposite("Member")
    memberRole.add(
        PermissionLeaf(
            PermissionBuilder()
                .entities(listOf(Entity.FILE))
                .resourceScope(ResourceScope.ALL)
                .baseOperation(BaseOperation.READ)
                .build()
        )
    )
    memberRole.add(
        PermissionLeaf(
            PermissionBuilder()
                .entities(listOf(Entity.FILE))
                .resourceScope(ResourceScope.USER)
                .baseOperation(BaseOperation.CREATE)
                .build()
        )
    )
    memberRole.add(
        PermissionLeaf(
            PermissionBuilder()
                .entities(listOf(Entity.PRODUCT))
                .resourceScope(ResourceScope.ALL)
                .baseOperation(BaseOperation.READ)
                .build()
        )
    )

    println("File Admin permissions: ${adminRoleFile.permission()}")
    println("Product Admin permissions: ${adminRoleProduct.permission()}")
    println("Global Admin permissions: ${globalAdminRole.permission()}")
    println("Member permissions: ${memberRole.permission()}")
}

fun main() {
    /**
     * The goal of the composite pattern is to treat individual objects and compositions of objects uniformly.
     * They will be structured in a tree-like structure.
     * the smallest unit will be the "leaf" and the composite will be the "branch". A "branch" should
     * also be able to contain other branches. The leaf and the branch should be able to be treated the same.
     *
     * In this system the smallest unit will be a Permission, and the branch will be a Role. A Role can contain
     * other Roles and Permissions.
     *
     * This example might not be exactly how the composite pattern should be implemented since the leaf takes a Permission
     * as constructor argument and the branch takes a Role as constructor argument. This means that the leaf and the branch
     * are not treated exactly the same but the functionality is the same.
     */
    run()
}

