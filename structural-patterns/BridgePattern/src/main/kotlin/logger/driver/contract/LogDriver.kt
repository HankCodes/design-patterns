package logger.driver.contract

interface LogDriver {
    fun driverType(): String
    fun log(level: String, message: String)
}
