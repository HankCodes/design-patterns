package structural.bridge.db

import structural.bridge.logger.driver.database.DbConnect


class Database {
    private lateinit var url: String

    fun setup(config: DbConfig = DbConfig): Database {
        val dbContainer = DbContainer(
            config.DATABASE_NAME,
            config.DATABASE_PASSWORD,
            config.DATABASE_USERNAME
        )

        url = dbContainer.start()

       return this
    }

    fun connect() {
        DbConnect.connect(
            url = url,
            user = DbConfig.DATABASE_USERNAME,
            password = DbConfig.DATABASE_PASSWORD
        )
    }
}