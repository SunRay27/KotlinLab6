package shapes2d

import kotlinx.serialization.Serializable

@Serializable
data class Color(val r: Float, val g: Float, val b: Float, val a: Float) {
    init {
        if (r < 0 || g < 0 || b < 0 || a < 0)
            throw IllegalArgumentException("Color components can't be negative")
    }

    override fun toString(): String {
        return "($r; $g; $b; $a)"
    }
}