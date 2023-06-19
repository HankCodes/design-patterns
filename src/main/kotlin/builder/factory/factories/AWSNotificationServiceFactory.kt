package builder.factory.factories

import builder.factory.factories.contracts.INotificationServiceFactory
import builder.factory.services.aws.AwsEmailService
import builder.factory.services.aws.AwsMessageService
import builder.factory.services.aws.AwsSmsService
import builder.factory.services.contracts.INotificationService


class AWSNotificationServiceFactory : INotificationServiceFactory {
    override fun create(type: String): INotificationService {
        return when (type) {
            "SMS" -> AwsSmsService()
            "EMAIL" -> AwsEmailService()
            "MESSAGE" -> AwsMessageService()
            else -> throw Exception("Boo")
        }
    }
}