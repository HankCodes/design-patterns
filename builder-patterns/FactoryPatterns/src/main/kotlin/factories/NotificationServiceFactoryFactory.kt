package factories

import factories.contracts.INotificationServiceFactory
import factories.contracts.INotificationServiceFactoryFactory

class NotificationServiceFactoryFactory : INotificationServiceFactoryFactory {

    override fun create(type: String): INotificationServiceFactory {
       return when (type) {
           "AWS" -> AWSNotificationServiceFactory()
           "AZURE" -> AzureNotificationServiceFactory()
           else -> throw Exception("Boo!")
       }
    }


}