package logger.driver.database

import Logs
import LogsDAO
import org.jetbrains.exposed.sql.transactions.transaction

class LogsRepository {
    fun addLog(level: String, message: String): Int = transaction {

            val newLog = LogsDAO.new {
                this.level = level
                this.message = message
            }

            println("New log entry created with ID: ${newLog.id.value}")

            newLog.id.value
        }

    fun getLogs(): List<LogsDAO> = transaction {
        LogsDAO.all().toList()
    }
}
