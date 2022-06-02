package shapes2d
import kotlinx.serialization.Serializable

@Serializable
data class Disk(val radius: Double, override val fillColor: Color, override val borderColor: Color) :
    BaseShape() {

    init {
        if (radius <= 0)
            throw IllegalArgumentException("Disc radius can't be equal or less than 0")
    }

    override fun calcArea(): Double {
        return Math.PI * radius * radius
    }

    override fun toString(): String {
        return "${this::class} Radius: $radius Area: ${calcArea()} Fill: $fillColor Border: $borderColor"
    }
}