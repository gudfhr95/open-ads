package io.openads.adsmanager.adaccount.domain.repository

import io.openads.adsmanager.adaccount.domain.entity.AdUser
import io.openads.adsmanager.adaccount.domain.vo.UserId
import org.springframework.data.repository.CrudRepository

interface AdUserRepository : CrudRepository<AdUser, Long> {
    fun existsByUserId(userId: UserId): Boolean
}
