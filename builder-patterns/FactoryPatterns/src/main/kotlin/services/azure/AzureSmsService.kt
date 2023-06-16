package services.azure

import services.contracts.INotificationService

class AzureSmsService : INotificationService {
    override fun send(message: String) {
       println("[AZURE SMS]: Message: $message")
    }
}