import db.Database
import logger.LoggerImpl
import logger.driver.ConsoleLogDriver
import logger.driver.database.DatabaseLogDriver
import logger.driver.FileSystemLogDriver
import logger.driver.HttpLogDriver
import logger.driver.database.LogsRepository

/**
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
 * LOGGING LIBRARY
 * (Should it be able to swap logger at runtime? Maybe just load the driver at runtime)
 * Logger interface/abstract class:
 * Logger(logDriver)
 * info(string)
 * warn(string)
 * error(string)
 *
 *  LogDriver interface
 *  log()
 *
 *  LogDrivers (implements LogDriver)
 *  FileSystemLogger
 *  DatabaseLogger
 *  ConsoleLogger
 *  HttpLogger
 *
 */
fun main(args: Array<String>) {

    val driver = when(val loggDriverType = args.first()) {
        "console" -> ConsoleLogDriver()
        "file" -> FileSystemLogDriver("logs.txt")
        "database" -> {
            Database()
                .setup()
                .connect()

            DatabaseLogDriver(LogsRepository())
        }
        "http" -> HttpLogDriver()
        else -> throw Exception("Invalid log driver: $loggDriverType")
    }

    val logger = LoggerImpl(driver)
    logger.info("Hello world")
    logger.warn("Hello world")
    logger.error("Hello world")
}