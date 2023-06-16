package factories.contracts

interface INotificationServiceFactoryFactory {
    fun create(type: String): INotificationServiceFactory
}