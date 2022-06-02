import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import shapes2d.*

internal class ShapeCollectorTest {

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

    @Test
    fun getMinAreaShape() {
        val collector = ShapeCollector()

        collector.add(disk1)
        collector.add(rect1)
        collector.add(square1)
        collector.add(tri1)

        assertEquals(2.0,collector.getMinAreaShape()?.calcArea())
    }

    @Test
    fun getMaxAreaShape() {
        val collector = ShapeCollector()

        collector.add(disk1)
        collector.add(rect1)
        collector.add(square1)
        collector.add(tri1)

        assertEquals(112.5,collector.getMaxAreaShape()?.calcArea())
    }

    @Test
    fun getTotalShapesArea() {
        val collector = ShapeCollector()

        collector.add(rect1)
        collector.add(rect2)
        collector.add(square1)
        collector.add(square2)
        collector.add(tri1)
        collector.add(tri2)

        assertEquals(402.0,collector.getTotalShapesArea())
    }

    @Test
    fun getAllShapesWithBorderColor() {
        val collector = ShapeCollector()

        collector.add(disk1)
        collector.add(disk2)
        collector.add(disk3)
        collector.add(rect1)
        collector.add(rect2)
        collector.add(rect3)
        collector.add(square1)
        collector.add(square2)
        collector.add(square3)
        collector.add(tri1)
        collector.add(tri2)
        collector.add(tri3)

       val bl : List<ColoredShape2D> = collector.getAllShapesWithBorderColor(black)
        bl.forEach {
            assertTrue(it.borderColor == black)
        }
        val r = collector.getAllShapesWithBorderColor(red)
            r.forEach {
            assertTrue(it.borderColor == red)
        }
        val trans = collector.getAllShapesWithBorderColor(transparent)
        trans.forEach {
            assertTrue(it.borderColor == transparent)
        }

        assertEquals(3,bl.count())
        assertEquals(3,r.count())
        assertEquals(3,trans.count())
    }

    @Test
    fun getAllShapesWithFillColor() {
        val collector = ShapeCollector()

        collector.add(disk1)
        collector.add(disk2)
        collector.add(disk3)
        collector.add(rect1)
        collector.add(rect2)
        collector.add(rect3)
        collector.add(square1)
        collector.add(square2)
        collector.add(square3)
        collector.add(tri1)
        collector.add(tri2)
        collector.add(tri3)

        val blu : List<ColoredShape2D> = collector.getAllShapesWithFillColor(blue)
        blu.forEach {
            assertTrue(it.fillColor == blue)
        }
        val w = collector.getAllShapesWithFillColor(white)
        w.forEach {
            assertTrue(it.fillColor == white)
        }
        val b = collector.getAllShapesWithFillColor(black)
        b.forEach {
            assertTrue(it.fillColor == black)
        }

        assertEquals(3,blu.count())
        assertEquals(3,w.count())
        assertEquals(3,b.count())
    }

    @Test
    fun getAllShapes() {
        val collector = ShapeCollector()

        collector.add(disk1)
        collector.add(disk2)
        collector.add(disk3)
        collector.add(rect1)
        collector.add(rect2)
        collector.add(rect3)
        collector.add(square1)
        collector.add(square2)
        collector.add(square3)
        collector.add(tri1)
        collector.add(tri2)
        collector.add(tri3)

        assertEquals(12,collector.getAllShapes().count())
    }

    @Test
    fun getAllShapesGroupedByFillColor() {
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

        var lastColor : Color

        collector.getAllShapesGroupedByFillColor().forEach {
            lastColor = it.key
            it.value.forEach{
                assertEquals(lastColor,it.fillColor)
            }
        }
    }

    @Test
    fun getAllShapesGroupedByBorderColor() {
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

        var lastColor : Color

        collector.getAllShapesGroupedByBorderColor().forEach {
            lastColor = it.key
            it.value.forEach{
                assertEquals(lastColor,it.borderColor)
            }
        }
    }

    @Test
    fun getAllShapesOfType() {
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

        collector.getAllShapesOfType(Disk::class).forEach {
            assertTrue(it::class == Disk::class)
        }
        assertEquals(3,collector.getAllShapesOfType(Disk::class).count())


        collector.getAllShapesOfType(Rect::class).forEach {
            assertTrue(it::class == Rect::class)
        }
        assertEquals(3,collector.getAllShapesOfType(Rect::class).count())


        collector.getAllShapesOfType(SquareRect::class).forEach {
            assertTrue(it::class == SquareRect::class)
        }
        assertEquals(3,collector.getAllShapesOfType(SquareRect::class).count())


        collector.getAllShapesOfType(Triangle::class).forEach {
            assertTrue(it::class == Triangle::class)
        }
        assertEquals(3,collector.getAllShapesOfType(Triangle::class).count())

        //yep, I was checking if it can return smth else...
    }
}