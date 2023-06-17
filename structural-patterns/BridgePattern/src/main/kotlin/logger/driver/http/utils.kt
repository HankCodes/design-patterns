package logger.driver.http

import kotlinx.coroutines.delay
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.io.IOException

suspend fun OkHttpClient.executeWithRetry(
    request: Request,
    maxRetries: Int = 5,
    retryIntervalMillis: Long = 1000,
    retryCondition: (Response) -> Boolean = { response ->
        response.code != 200
    }
): Response {
    var response: Response? = null
    var retryCount = 0
    while (retryCount <= maxRetries) {
        try {
            response?.close()

            response = newCall(request).execute()

            if (!retryCondition(response)) {
                return response
            }


        } catch (e: Exception) {
            retryCount++
            delay(retryIntervalMillis)
        }
    }

    throw IOException("Failed to get a successful response after $maxRetries retries")
}
