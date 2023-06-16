package services.aws

import services.contracts.INotificationService

class AwsMessageService : INotificationService {
    override fun send(message: String) {
        println("[AWS MESSAGE]: Message: $message")
    }
}