package shapes2d

import kotlinx.serialization.Serializable

@Serializable
data class Vector2(val x: Double, val y: Double) {
    override fun toString(): String {
        return "($x; $y)"
    }
}