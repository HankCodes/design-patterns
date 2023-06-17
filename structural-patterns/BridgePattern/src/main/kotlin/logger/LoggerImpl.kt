package logger

import logger.driver.contract.LogDriver

class LoggerImpl(private val driver: LogDriver) : Logger {
    companion object {
        const val LEVEL_INFO = "INFO"
        const val LEVEL_WARN = "WARN"
        const val LEVEL_ERROR = "ERROR"
    }
    override fun info(message: String) {
        driver.log(LEVEL_INFO, printWithDriverType(message))
    }

    override fun warn(message: String) {
        driver.log(LEVEL_WARN, printWithDriverType(message))
    }

    override fun error(message: String) {
        driver.log(LEVEL_ERROR, printWithDriverType(message))
    }

    private fun printWithDriverType(message: String): String = "$message - Driver type: ${driver.driverType()}"
}