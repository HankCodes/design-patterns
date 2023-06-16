package services.azure

import services.contracts.INotificationService

class AzureMessageService : INotificationService {
    override fun send(message: String) {
        println("[AZURE MESSAGE]: Message: $message")
    }
}