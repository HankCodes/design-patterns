package server

import io.ktor.server.netty.*
import io.ktor.server.routing.*
import io.ktor.server.application.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.response.*
import io.ktor.server.engine.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.request.*

fun startServer() = embeddedServer(Netty, 8080) {
        println("server running on 8080")

        install(ContentNegotiation) {
            json()
        }

        routing {
            get("/") {
                call.respondText("Hello, world!", ContentType.Text.Html)
            }

            post("/logs") {
                try {
                    println("Received POST req")
                    val logMessage = call.receive<LogMessage>()

                    println("Received log: ${logMessage.level} - ${logMessage.message}")
                    call.respond(HttpStatusCode.OK)

                } catch (e: Exception) {
                    println("Error: $e")
                    println(e.stackTraceToString())
                }
            }
        }
    }.start(wait = true)
