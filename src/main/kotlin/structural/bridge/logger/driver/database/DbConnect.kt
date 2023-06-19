package structural.bridge.logger.driver.database

import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction

object DbConnect {
    fun connect(
        url: String,
        driver: String = "org.postgresql.Driver",
        user: String,
        password: String
    ) {
        Database.connect(
            url = url,
            driver = driver,
            user = user,
            password = password
        )

        transaction {
            SchemaUtils.create(Logs)
        }
    }
}
