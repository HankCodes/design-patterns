package builder.factory.services.azure

import builder.factory.services.contracts.INotificationService


class AzureSmsService : INotificationService {
    override fun send(message: String) {
       println("[AZURE SMS]: Message: $message")
    }
}