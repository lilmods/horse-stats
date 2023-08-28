package dev.gallon.horsestatsmod.common.services

import com.google.common.cache.CacheBuilder
import com.google.common.cache.CacheLoader
import dev.gallon.horsestatsmod.common.domain.I18nKeys
import dev.gallon.horsestatsmod.common.repositories.I18nRepository
import dev.gallon.horsestatsmod.common.repositories.UserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import java.util.*
import java.util.concurrent.TimeUnit

class UserCacheService(
    val userRepository: UserRepository,
    val i18nRepository: I18nRepository,
) {
    private val coroutineScope = CoroutineScope(Dispatchers.IO)

    private val cache = CacheBuilder
        .newBuilder()
        .expireAfterWrite(6, TimeUnit.HOURS)
        .build(object : CacheLoader<UUID, Deferred<String>>() {
            override fun load(uuid: UUID): Deferred<String> = coroutineScope
                .async {
                    userRepository
                        .fetchUsernameFromUUID(uuid)
                        ?: i18nRepository.get(I18nKeys.UNKNOWN_PLAYER)
                }
        })

    fun fetchUsernameFromUuid(uuid: UUID): Deferred<String> = cache[uuid]
}
