package io.openads.adsmanager.adaccount.domain.event

import io.openads.adsmanager.adaccount.domain.vo.UserId

data class AdUserCreated(
    val userId: UserId,
    val name: String,
    val email: String,
)
