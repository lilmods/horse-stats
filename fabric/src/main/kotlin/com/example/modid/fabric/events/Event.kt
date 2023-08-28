package dev.gallon.horsestatsmod.fabric.events

sealed interface Event

data class TickEvent(
    val something: String
) : Event
