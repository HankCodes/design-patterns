import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable

object Logs : IntIdTable() {
    val level = varchar("level", 50)
    val message = varchar("message", 255)
}

class LogsDAO(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<LogsDAO>(Logs)

    var level by Logs.level
    var message by Logs.message
}
