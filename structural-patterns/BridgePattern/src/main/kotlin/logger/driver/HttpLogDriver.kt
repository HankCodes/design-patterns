package logger.driver

class HttpLogDriver : LogDriver {
    override fun driverType(): String = "HTTP"

    override fun log(level: String, message: String) {
        TODO("Not yet implemented")
    }
}