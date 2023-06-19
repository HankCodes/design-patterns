package builder.factory.services.azure

import builder.factory.services.contracts.INotificationService


class AzureEmailService : INotificationService {
    override fun send(message: String) {
        println("[AZURE EMAIL]: Message: $message")
    }
}
