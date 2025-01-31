package io.openads.adsmanager.adaccount.domain.repository

import io.openads.adsmanager.adaccount.domain.entity.AdUser
import org.springframework.data.repository.kotlin.CoroutineCrudRepository

interface AdUserRepository : CoroutineCrudRepository<AdUser, Long> {
    suspend fun existsByUserId(userId: String): Boolean
}
