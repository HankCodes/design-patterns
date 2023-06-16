package services.azure

import services.contracts.INotificationService

class AzureEmailService : INotificationService {
    override fun send(message: String) {
        println("[AZURE EMAIL]: Message: $message")
    }
}
