package services.aws

import services.contracts.INotificationService

class AwsSmsService : INotificationService {
    override fun send(message: String) {
       println("[AWS SMS]: Message: $message")
    }
}