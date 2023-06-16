package factories.contracts

import services.contracts.INotificationService

interface INotificationServiceFactory {
    fun create(type: String): INotificationService
}