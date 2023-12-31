package structural.bridge.logger.driver.database

import structural.bridge.logger.driver.contract.LogDriver


class DatabaseLogDriver(private val repository: LogsRepository) : LogDriver {
    override fun driverType(): String = "database"

    override fun log(level: String, message: String) {
       repository.addLog(level, message)
    }
}