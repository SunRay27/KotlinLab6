package shapes2d

import kotlinx.serialization.Serializable

@Serializable
data class SquareRect(val size: Double, override val fillColor: Color, override val borderColor: Color) :
    BaseShape() {

    init {
        if (size <= 0)
            throw IllegalArgumentException("Rect size can't be negative or 0")
    }

    override fun calcArea(): Double {
        return size * size
    }

    override fun toString(): String {
        return "${this::class} Size: $size Area: ${calcArea()} Fill: $fillColor Border: $borderColor"
    }
}
