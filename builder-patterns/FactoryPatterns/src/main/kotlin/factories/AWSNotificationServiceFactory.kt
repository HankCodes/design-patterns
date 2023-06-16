package factories

import factories.contracts.INotificationServiceFactory
import services.contracts.INotificationService
import services.aws.AwsEmailService
import services.aws.AwsMessageService
import services.aws.AwsSmsService

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