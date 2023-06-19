package builder.factory.factories.contracts

import builder.factory.services.contracts.INotificationService


interface INotificationServiceFactory {
    fun create(type: String): INotificationService
}