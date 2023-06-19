package structural.bridge.server

import kotlinx.serialization.Serializable

@Serializable
data class LogMessage(val level: String, val message: String)
