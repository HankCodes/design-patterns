package builder.factory.factories

import builder.factory.factories.contracts.INotificationServiceFactory
import builder.factory.factories.contracts.INotificationServiceFactoryFactory

class NotificationServiceFactoryFactory : INotificationServiceFactoryFactory {

    override fun create(type: String): INotificationServiceFactory {
       return when (type) {
           "AWS" -> AWSNotificationServiceFactory()
           "AZURE" -> AzureNotificationServiceFactory()
           else -> throw Exception("Boo!")
       }
    }


}