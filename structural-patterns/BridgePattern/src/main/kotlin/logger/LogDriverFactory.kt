package logger

import db.Database
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import logger.driver.ConsoleLogDriver
import logger.driver.FileSystemLogDriver
import logger.driver.contract.LogDriver
import logger.driver.database.DatabaseLogDriver
import logger.driver.database.LogsRepository
import logger.driver.http.HttpLogDriver
import okhttp3.OkHttpClient
import server.startServer

class LogDriverFactory {

   fun createDriver(type: String): LogDriver = when(type) {
           "console" -> ConsoleLogDriver()
           "file" -> FileSystemLogDriver("logs.txt")
           "database" -> createDatabaseDriver()
           "http" -> createHttpDriver()
           else -> {
               println("Invalid log driver: $type, defaults to console")
               ConsoleLogDriver()
           }
       }

    private fun createHttpDriver(): LogDriver {
        val scope = CoroutineScope(Dispatchers.IO)
        scope.launch {
            startServer()
        }

        val url = "http://localhost:8080/logs"
        val client = OkHttpClient()

        return HttpLogDriver(client, url)
    }

    private fun createDatabaseDriver(): LogDriver {
        Database()
            .setup()
            .connect()

        return DatabaseLogDriver(LogsRepository())
    }
}

