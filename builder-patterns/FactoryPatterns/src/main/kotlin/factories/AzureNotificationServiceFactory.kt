package factories

import factories.contracts.INotificationServiceFactory
import services.contracts.INotificationService
import services.azure.AzureEmailService
import services.azure.AzureMessageService
import services.azure.AzureSmsService

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