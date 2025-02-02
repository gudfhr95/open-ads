package io.openads.adsmanager.adaccount.input.rest.v1.aduser

import io.openads.adsmanager.adaccount.domain.entity.AdUser
import io.openads.adsmanager.adaccount.domain.vo.AdUserId

data class AdUserResponseV1(
    val adUserId: AdUserId,
    val name: String,
    val email: String,
) {
    companion object {
        fun from(adUser: AdUser) = AdUserResponseV1(
            adUserId = adUser.adUserId,
            name = adUser.name,
            email = adUser.email,
        )
    }
}
