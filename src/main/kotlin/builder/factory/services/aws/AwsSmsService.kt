package builder.factory.services.aws

import builder.factory.services.contracts.INotificationService


class AwsSmsService : INotificationService {
    override fun send(message: String) {
       println("[AWS SMS]: Message: $message")
    }
}