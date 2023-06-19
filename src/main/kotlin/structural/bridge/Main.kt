package structural.bridge

import structural.bridge.logger.LogDriverFactory
import structural.bridge.logger.LoggerImpl

/**
 * WHAT IS THE BRIDGE PATTERN?
 * Bridge is a structural design pattern that lets you split a large class or a set of closely related classes into
 * two separate hierarchies—abstraction and implementation—which can be developed independently of each other.
 *
 * This is a solution that aims to help with large and complex objects where some functionality frequently changes.
 *
 * The core principal is that you have a class that implements an interface. This interface have some sort of operation
 * it can do. But the implementation of these operations is yet another interface, and the classes that implements this
 * interfaces will be passed into the first class.
 *
 * An example would be a Shape interface or abstract class that has a drawing() function, but it will also take a
 * DrawingAPI interface/abstract class as constructor argument. When someone calls Shape.drawing(), the Shape instances
 * will delegate the work to the DrawingAPI implementations. They both have the functionality of drawing the shape,
 * but the actual implementation of how that is done is delegated to a dedicated interface/abstract class that will
 * handle the operation. This means that changes in the DrawingAPI can be developed separately from all the Shapes
 * in the application. This enables the rest of the application to remain unedited if changes to how shapes are drawn.
 *
 * By using the Bridge pattern, you can switch or extend the hierarchies independently.
 * For example, you can introduce new shape classes without modifying the existing rendering classes, or vice versa.
 * This decoupling allows for greater flexibility and scalability in the system.
 */

/**
 * THIS EXAMPLE
 *
 * In this example we have a Logger that can log either to the console, a file, a database or a http endpoint.
 * One approach to make a Logger that is extensible is to have a Logger interface and let each log type implement this interface.
 * We would, then, have four different logger classes, one for each type, that extends the Logger interface.
 *
 * Another approach is to utilize the Bridge Pattern.
 * We introduce a LogDriver interface instead. The classes that implements the LogDriver
 * will take care of the actual implementation of the logging. This will separate the contract from the implementation.
 * The Logger interface is still implemented by only one class, but this class will take a LogDriver as constructor argument
 * which will take care of the actual implementation of the logging. The implementation of the Logger interface will simply pass along
 * the operation to the LogDriver.
 *
 */

/**
 * LOGGING LIBRARY
 * The logging library will consist of these entities.
 *
 * Logger interface:
 * info(string)
 * warn(string)
 * error(string)
 *
 *  LogDriver interface
 *  log(level, message)
 *
 *  LogDrivers (implements LogDriver)
 *  FileSystemLogger
 *  DatabaseLogger
 *  ConsoleLogger
 *  HttpLogger
 *
 *  LoggerImpl (implements Logger) will take a LogDriver as constructor argument.
 *
 */
fun main(args: Array<String>) {

    // We take the log type from command line argument
    // Supported arguments: console, file, database, http
    // To run the application, run the following command: ./gradlew run --args="<logging type>"
    val loggerType = args.first()

    // The LogDriverFactory will create the correct LogDriver, the LogDriver is a crucial part of the Bridge Pattern,
    // the factory is for convenience only. LogDriver interface only consist of one method: log(level, message)
    val driver = LogDriverFactory().createDriver(loggerType)

    // The LoggerImpl() is the ony implementation on the Logger interface we need since we have the LogDriver.
    // Not using the Bridge Pattern would mean that we would have to implement the Logger interface for each logging type.
    val logger = LoggerImpl(driver)

    val logMessage = "This is the log message"
    logger.info(logMessage)
    logger.warn(logMessage)
    logger.error(logMessage)
}