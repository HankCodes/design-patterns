package structural.bridge.logger

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import structural.bridge.db.Database
import structural.bridge.logger.driver.ConsoleLogDriver
import structural.bridge.logger.driver.FileSystemLogDriver
import structural.bridge.logger.driver.contract.LogDriver
import structural.bridge.logger.driver.database.DatabaseLogDriver
import structural.bridge.logger.driver.database.LogsRepository
import structural.bridge.logger.driver.http.HttpLogDriver
import structural.bridge.server.startServer


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

