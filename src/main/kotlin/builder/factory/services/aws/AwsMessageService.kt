package builder.factory.services.aws

import builder.factory.services.contracts.INotificationService


class AwsMessageService : INotificationService {
    override fun send(message: String) {
        println("[AWS MESSAGE]: Message: $message")
    }
}