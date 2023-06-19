package builder.factory.services.azure

import builder.factory.services.contracts.INotificationService


class AzureMessageService : INotificationService {
    override fun send(message: String) {
        println("[AZURE MESSAGE]: Message: $message")
    }
}