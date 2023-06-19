package structural.bridge

import structural.bridge.logger.LoggerImpl
import structural.bridge.logger.driver.FileSystemLogDriver
import java.io.File
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.util.*
import kotlin.test.assertContains

class FileSystemDriverLoggerTest {

    private val path = "logs-test.txt"
    private val sut = LoggerImpl(FileSystemLogDriver(path))

    private fun getFileContent(): String =
        File(path).readBytes().toString(Charsets.UTF_8)

    @BeforeEach
    fun setup() {
        File(path).createNewFile()
    }

    @AfterEach
    fun teardown() {
        File(path).delete()
    }

    @Test
    fun `Log gets stored in file`() {
        val uniqueLogMessage = "Test log ${UUID.randomUUID()}"

        sut.info(uniqueLogMessage)

        val fileContent = getFileContent()
        assertContains(fileContent, uniqueLogMessage)
    }

    @Test
    fun `Log level INFO gets stored in file`() {
        val uniqueLogMessage = "Test log ${UUID.randomUUID()}"

        sut.info(uniqueLogMessage)

        val fileContent = getFileContent()
        assertContains(fileContent, "INFO")
    }

    @Test
    fun `Log level WARN gets stored in file`() {
        val uniqueLogMessage = "Test log ${UUID.randomUUID()}"

        sut.warn(uniqueLogMessage)

        val fileContent = getFileContent()
        assertContains(fileContent, "WARN")
    }

    @Test
    fun `Log level ERROR gets stored in file`() {
        val uniqueLogMessage = "Test log ${UUID.randomUUID()}"

        sut.error(uniqueLogMessage)

        val fileContent = getFileContent()
        assertContains(fileContent, "ERROR")
    }
}