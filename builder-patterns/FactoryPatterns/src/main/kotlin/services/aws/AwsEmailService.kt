package services.aws

import services.contracts.INotificationService

class AwsEmailService : INotificationService {
    override fun send(message: String) {
        println("[AWS EMAIL]: Message: $message")
    }
}
