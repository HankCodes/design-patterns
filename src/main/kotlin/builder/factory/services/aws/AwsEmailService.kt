package builder.factory.services.aws

import builder.factory.services.contracts.INotificationService


class AwsEmailService : INotificationService {
    override fun send(message: String) {
        println("[AWS EMAIL]: Message: $message")
    }
}
