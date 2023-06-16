package logger.driver

class ConsoleLogDriver : LogDriver {
    override fun driverType(): String = "console"

    override fun log(level: String, message: String) {
        val logMessage = "[$level] $message"
        println(logMessage)
    }
}