package shapes2d

import kotlin.math.abs
import kotlinx.serialization.*

@Serializable
data class Triangle(
    val p1: Vector2,
    val p2: Vector2,
    val p3: Vector2,
    override val fillColor: Color,
    override val borderColor: Color
) : BaseShape() {
    override fun calcArea(): Double {
        return 0.5 * abs(p1.x * (p2.y - p3.y) + p2.x * (p3.y - p1.y) + p3.x * (p1.y - p2.y))
    }

    override fun toString(): String {
        return "${this::class} P1: $p1 P2: $p2 P3: $p1 Area: ${calcArea()} Fill: $fillColor Border: $borderColor"
    }
}