package io.openads.adsmanager.adaccount.domain.repository

import io.openads.adsmanager.adaccount.domain.entity.AdUser
import io.openads.adsmanager.adaccount.domain.vo.UserId
import org.springframework.data.repository.kotlin.CoroutineCrudRepository

interface AdUserRepository : CoroutineCrudRepository<AdUser, Long> {
    suspend fun existsByUserId(userId: UserId): Boolean
}
