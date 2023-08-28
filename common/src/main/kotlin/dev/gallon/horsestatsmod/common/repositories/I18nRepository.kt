package dev.gallon.horsestatsmod.common.repositories

fun interface I18nRepository {
    fun get(key: String): String
}
