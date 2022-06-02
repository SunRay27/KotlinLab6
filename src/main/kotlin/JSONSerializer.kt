import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic
import shapes2d.*


class JSONSerializer {
    val json = Json {
        prettyPrint = true
        serializersModule = SerializersModule {
            polymorphic(BaseShape::class) {
                subclass(Disk::class, Disk.serializer())
                subclass(Rect::class, Rect.serializer())
                subclass(SquareRect::class, SquareRect.serializer())
                subclass(Triangle::class, Triangle.serializer())
            }
        }
    }

    inline fun <reified T> serialize(shapeCollector: T): String {
        return json.encodeToString(shapeCollector)
    }

    inline fun <reified T> deserialize(shapeCollectorJSON: String): T {
        return json.decodeFromString(shapeCollectorJSON)
    }
}