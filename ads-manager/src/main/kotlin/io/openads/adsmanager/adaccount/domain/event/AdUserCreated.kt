package io.openads.adsmanager.adaccount.domain.event

import io.openads.adsmanager.adaccount.domain.vo.AdUserId
import org.springframework.modulith.events.Externalized

@Externalized("ad-account.ad-user-created")
data class AdUserCreated(
    val adUserId: AdUserId,
    val name: String,
    val email: String,
)
