package db

import org.testcontainers.containers.PostgreSQLContainer

class DbContainer(
    private val databaseName: String,
    private val password: String,
    private val username: String
) {

    fun start(): String {
        val postgresContainer: PostgreSQLContainer<*> = PostgreSQLContainer("postgres:latest")
            .withUsername(username)
            .withPassword(password)
            .withDatabaseName(databaseName)

        postgresContainer.start()

        return postgresContainer.jdbcUrl
    }
}