package structural.composite.permissions

class PermissionBuilder {
    private var entities: List<Entity>? = null
    private var entityProperty: EntityProperty? = null
    private var resourceScope: ResourceScope? = null
    private var baseOperation: BaseOperation? = null

    fun entities(entities: List<Entity>) = apply { this.entities = entities }
    fun entityProperty(entityProperty: EntityProperty) = apply { this.entityProperty = entityProperty }
    fun resourceScope(resourceScope: ResourceScope) = apply { this.resourceScope = resourceScope }
    fun baseOperation(baseOperation: BaseOperation) = apply { this.baseOperation = baseOperation }

    fun build(): Permission {
        return Permission(entities, entityProperty, resourceScope, baseOperation)
    }
}