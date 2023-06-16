package logger.driver

interface LogDriver {
    fun driverType(): String
    fun log(level: String, message: String)
}
