import factories.NotificationServiceFactoryFactory

fun main(args: Array<String>) {
    /**
     * 1) We need to create an object, but we only know the concrete type at runtime
     * 2) Must be more than one class/type to create
     * 3) The code should be Open to extension but Closed for modification
     *
     * To achieve this we need to have an interface for the concrete classes to implement.
     * But not only that, the factory that creates the concrete classes should also be an interface.
     * What this does for us is that we abstract how we create the classes.
     * */

    // App idea: NotificationService, SMS, Email, Message
    // From different vendors
    // Abstract factory to account for the vendor
    // Abstract implementations of  SMS, Email, Message
    val notificationServiceFactory = NotificationServiceFactoryFactory()
    val awsNotificationServiceFactory = notificationServiceFactory.create("AWS")
    val azureNotificationServiceFactory = notificationServiceFactory.create("AZURE")

    // AWS
    val awsSMSService = awsNotificationServiceFactory.create("SMS")
    val awsEmailService = awsNotificationServiceFactory.create("EMAIL")
    val awsMessageService = awsNotificationServiceFactory.create("MESSAGE")

    awsSMSService.send("Hi AWS by sms")
    awsEmailService.send("Hi AWS by email")
    awsMessageService.send("Hi AWS by message")

    // Azure
    val azureSMSService = azureNotificationServiceFactory.create("SMS")
    val azureEmailService = azureNotificationServiceFactory.create("EMAIL")
    val azureMessageService = azureNotificationServiceFactory.create("MESSAGE")

    azureSMSService.send("Hi Azure by sms")
    azureEmailService.send("Hi Azure by email")
    azureMessageService.send("Hi Azure by message")
}