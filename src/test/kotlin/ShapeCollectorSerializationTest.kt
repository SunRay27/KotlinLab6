import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import shapes2d.*

internal class ShapeCollectorSerializationTest {

    val red = Color(1f, 0f, 0f, 1f)
    val green = Color(0f, 1f, 0f, 1f)
    val blue = Color(0f, 0f, 1f, 1f)
    val white = Color(1f, 1f, 1f, 1f)
    val black = Color(0f, 0f, 0f, 1f)
    val transparent = Color(0f, 0f, 0f, 0f)

    val disk1 = Disk(1.0, white, black)
    val disk2 = Disk(2.0, white, black)
    val disk3 = Disk(3.0, white, black)

    val square1 = SquareRect(5.0, black, red)
    val square2 = SquareRect(10.0, black, red)
    val square3 = SquareRect(15.0, black, red)

    val rect1 = Rect(Vector2(2.0, 1.0), blue, transparent)
    val rect2 = Rect(Vector2(5.0, 10.0), blue, transparent)
    val rect3 = Rect(Vector2(25.0, 100.0), blue, transparent)

    val tri1 = Triangle(
        Vector2(0.0, 0.0),
        Vector2(15.0, 0.0),
        Vector2(0.0, 15.0),
        green,
        blue
    )
    val tri2 = Triangle(
        Vector2(0.0, 0.0),
        Vector2(15.0, 0.0),
        Vector2(0.0, 15.0),
        green,
        blue
    )
    val tri3 = Triangle(
        Vector2(0.0, 0.0),
        Vector2(-15.0, 0.0),
        Vector2(0.0, 25.0),
        green,
        blue
    )

    val serializer = JSONSerializer()

    @Test
    fun deserializationTest() {

        val collector = ShapeCollector()

        collector.add(disk1)
        collector.add(rect1)
        collector.add(square1)
        collector.add(tri1)
        collector.add(disk2)
        collector.add(rect2)
        collector.add(square2)
        collector.add(tri2)
        collector.add(disk3)
        collector.add(rect3)
        collector.add(square3)
        collector.add(tri3)

        val deserialized = serializer.deserialize<ShapeCollector>(serializer.serialize(collector))

        for (i in 0 until collector.getAllShapes().count())
            assertTrue(collector.getAllShapes()[i] == deserialized.getAllShapes()[i])
    }
}