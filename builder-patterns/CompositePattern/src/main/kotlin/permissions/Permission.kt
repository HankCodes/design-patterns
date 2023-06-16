package permissions


enum class BaseOperation {
    CREATE,
    READ,
    UPDATE,
    DELETE
}

enum class ResourceScope {
    ALL,
    USER
}

enum class Entity {
    FILE,
    PRODUCT,
    EMPLOYEE,
    TEAM,
    DEPARTMENT,
    ORGANIZATION
}

enum class EntityProperty {
    METADATA,
    INFORMATION,
    ROLE,
    SALARY,
    MEMBER,
    ECONOMY
}

class Permission(
    private val entities: List<Entity>?,
    private val entityProperty: EntityProperty?,
    private val resourceScope: ResourceScope?,
    private val baseOperation: BaseOperation?,
) {
    private val delimiter = "."

    fun getPermission(): String {
        return listOfNotNull(
            entities?.joinToString(delimiter),
            entityProperty?.name,
            resourceScope?.name,
            baseOperation?.name,
        ).joinToString(delimiter)
    }
}