package structural.bridge.logger.driver

import structural.bridge.logger.driver.contract.LogDriver
import java.io.BufferedWriter
import java.io.File
import java.io.FileWriter

class FileSystemLogDriver(private val filePath: String) : LogDriver {
    override fun driverType(): String = "file"

    override fun log(level: String, message: String) {
        try {
            val logEntry = "[$level] $message\n"

            val file = File(filePath)
            val fileWriter = FileWriter(file, true)
            val bufferedWriter = BufferedWriter(fileWriter)

            bufferedWriter.append(logEntry)

            bufferedWriter.close()
            fileWriter.close()
        } catch (e: Exception) {
            println("Could not write to file")
            e.printStackTrace()
        }
    }
}