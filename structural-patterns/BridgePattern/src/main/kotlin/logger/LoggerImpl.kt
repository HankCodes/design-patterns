package logger

import logger.driver.LogDriver

class LoggerImpl(private val driver: LogDriver) : Logger {
    companion object {
        const val LEVEL_INFO = "INFO"
        const val LEVEL_WARN = "WARN"
        const val LEVEL_ERROR = "ERROR"
    }
    override fun info(message: String) {
        printDriverType()
        driver.log(LEVEL_INFO, message)
    }

    override fun warn(message: String) {
        printDriverType()
        driver.log(LEVEL_WARN, message)
    }

    override fun error(message: String) {
        printDriverType()
        driver.log(LEVEL_ERROR, message)
    }

    private fun printDriverType() {
        println("Driver type: ${driver.driverType()}")
    }
}