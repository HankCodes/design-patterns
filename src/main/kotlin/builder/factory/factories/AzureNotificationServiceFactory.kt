package builder.factory.factories

import builder.factory.factories.contracts.INotificationServiceFactory
import builder.factory.services.azure.AzureEmailService
import builder.factory.services.azure.AzureMessageService
import builder.factory.services.azure.AzureSmsService
import builder.factory.services.contracts.INotificationService

class AzureNotificationServiceFactory : INotificationServiceFactory {
    override fun create(type: String): INotificationService {
        return when (type) {
            "SMS" -> AzureSmsService()
            "EMAIL" -> AzureEmailService()
            "MESSAGE" -> AzureMessageService()
            else -> throw Exception("Boo")
        }
    }
}