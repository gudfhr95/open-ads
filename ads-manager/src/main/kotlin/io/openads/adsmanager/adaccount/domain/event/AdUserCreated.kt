package io.openads.adsmanager.adaccount.domain.event

import io.openads.adsmanager.common.domain.vo.UserId

data class AdUserCreated(
    val userId: UserId,
    val name: String,
)
