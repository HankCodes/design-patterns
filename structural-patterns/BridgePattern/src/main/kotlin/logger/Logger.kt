package logger

interface Logger {
    fun info(message: String)
    fun warn(message: String)
    fun error(message: String)
}