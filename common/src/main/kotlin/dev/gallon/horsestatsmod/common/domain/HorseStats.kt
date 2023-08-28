package dev.gallon.horsestatsmod.common.domain

data class HorseStats(
    val health: Double,
    val jump: Double,
    val speed: Double,
    val inventory: Int?,
    val owner: String?
) {
    companion object {
        const val MIN_HEALTH = 15
        const val MAX_HEALTH = 30
        const val MIN_JUMP_HEIGHT = 1.25
        const val MAX_JUMP_HEIGHT = 5
        const val MIN_SPEED = 4.8
        const val MAX_SPEED = 14.5
        const val MIN_SLOTS = 3
        const val MAX_SLOTS = 15
    }
}
