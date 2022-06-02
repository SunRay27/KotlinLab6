package shapes2d

import kotlinx.serialization.*

@Serializable
sealed class BaseShape : Shape2D, ColoredShape2D {
    abstract override val fillColor: Color
    abstract override val borderColor: Color
    override fun toString(): String {
        return "${this::class} Area: ${calcArea()} Fill: $fillColor Border: $borderColor"
    }
}