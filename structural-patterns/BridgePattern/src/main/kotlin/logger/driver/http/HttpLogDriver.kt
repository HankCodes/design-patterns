package logger.driver.http

import kotlinx.coroutines.runBlocking
import logger.driver.contract.LogDriver
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody

class HttpLogDriver(
    private val client: OkHttpClient = OkHttpClient(),
    private val url: String
) : LogDriver {

    override fun driverType(): String = "HTTP"

    override fun log(level: String, message: String) {
        runBlocking {

            val logData = """{"level": "$level", "message": "$message"}"""
            val mediaType = "application/json".toMediaType()
            val requestBody = logData.toRequestBody(mediaType)

            val request = Request.Builder()
                .url(url)
                .post(requestBody)
                .build()

            val response = client.executeWithRetry(request)
            response.close()
        }
    }
}
