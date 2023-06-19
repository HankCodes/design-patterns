package builder.factory

import builder.factory.factories.NotificationServiceFactoryFactory


/**
 * ABSRACT FACTORY PATTERN
 * The abstract factory pattern is used to create a family of related objects.
 * It is also called a factory of factories.
 * What is meant by this is that a factory will be used to create objects of a certain type.
 * But in some cases you might need different factories to create different types of the same kind of objects/interfaces.
 *
 * The abstract factory pattern is used when:
 * 1) You need to create a family of related objects
 * 2) You want to expose a single interface to create multiple objects
 * 3) The code should be Open to extension but Closed for modification
 *
 * To achieve this we need to have an interface for the concrete classes to implement.
 * But not only that, the factory that creates the concrete classes should also be an interface.
 * What this does for us is that we abstract how we create the classes.
 *
 * In this example we will build a notification service. It will be able to send notifications
 * over different channels such as SMS, Email and Message (Message is just something generic to prove a concept).
 *
 * In our fictive case we have two different cloud providers, AWS and Azure.
 * Each of these providers have their own way of sending notifications, but they can still use the same interfaces.
 * To be able to both support the different notification channels and the different cloud providers we need to
 * create a factory of factories.
 *
 * The INotification interface is the interface that all notification services need to implement.
 * The INotificationServiceFactory is the interface that all notification service factories need to implement.
 *
 **/
fun main() {

    // Create the factories one for AWS and one for AZURE
    val notificationServiceFactory = NotificationServiceFactoryFactory()
    val awsNotificationServiceFactory = notificationServiceFactory.create("AWS")
    val azureNotificationServiceFactory = notificationServiceFactory.create("AZURE")

    // Create the different notification services for each channel using the factories
    // AWS
    val awsSMSService = awsNotificationServiceFactory.create("SMS")
    val awsEmailService = awsNotificationServiceFactory.create("EMAIL")
    val awsMessageService = awsNotificationServiceFactory.create("MESSAGE")

    // Azure
    val azureSMSService = azureNotificationServiceFactory.create("SMS")
    val azureEmailService = azureNotificationServiceFactory.create("EMAIL")
    val azureMessageService = azureNotificationServiceFactory.create("MESSAGE")

    // Send some notifications
    awsSMSService.send("Hi AWS by sms")
    awsEmailService.send("Hi AWS by email")
    awsMessageService.send("Hi AWS by message")

    azureSMSService.send("Hi Azure by sms")
    azureEmailService.send("Hi Azure by email")
    azureMessageService.send("Hi Azure by message")
}