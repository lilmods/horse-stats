package dev.gallon.horsestatsmod.common.repositories

import java.util.*

fun interface UserRepository {
    suspend fun fetchUsernameFromUUID(uuid: UUID): String?
}
