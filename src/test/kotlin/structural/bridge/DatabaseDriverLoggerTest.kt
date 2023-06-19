package structural.bridge

import org.junit.jupiter.api.Test
import kotlin.test.assertNotNull
import structural.bridge.db.Database
import structural.bridge.logger.LoggerImpl
import structural.bridge.logger.driver.database.DatabaseLogDriver
import structural.bridge.logger.driver.database.LogsRepository
import java.util.*
import kotlin.test.assertEquals

class DatabaseDriverLoggerTest {

    private val repository = LogsRepository()
    private val sut = LoggerImpl(DatabaseLogDriver(repository))

    companion object {
        init {
            Database()
                .setup()
                .connect()
        }
    }

    @Test
    fun `Log gets stored in database`() {
        val uniqueLogMessage = "Test log ${UUID.randomUUID()}"

        sut.info(uniqueLogMessage)

        val logs = repository.getLogs()
        val actual = logs.firstOrNull() { it.message.contains(uniqueLogMessage) }

        assertNotNull(actual)

    }

    @Test
    fun `Log level INFO gets stored in database`() {

        val uniqueLogMessage = "Test log ${UUID.randomUUID()}"

        sut.info(uniqueLogMessage)

        val logs = repository.getLogs()
        val log = logs.firstOrNull() { it.message.contains(uniqueLogMessage) }

        val expected = "INFO"
        val actual = log?.level

        assertEquals(expected, actual)
    }

    @Test
    fun `Log level WARN gets stored in database`() {

        val uniqueLogMessage = "Test log ${UUID.randomUUID()}"

        sut.warn(uniqueLogMessage)

        val logs = repository.getLogs()
        val log = logs.firstOrNull() { it.message.contains(uniqueLogMessage) }

        val expected = "WARN"
        val actual = log?.level

        assertEquals(expected, actual)
    }

    @Test
    fun `Log level ERROR gets stored in database`() {

        val uniqueLogMessage = "Test log ${UUID.randomUUID()}"

        sut.error(uniqueLogMessage)

        val logs = repository.getLogs()
        val log = logs.firstOrNull() { it.message.contains(uniqueLogMessage) }

        val expected = "ERROR"
        val actual = log?.level

        assertEquals(expected, actual)
    }
}