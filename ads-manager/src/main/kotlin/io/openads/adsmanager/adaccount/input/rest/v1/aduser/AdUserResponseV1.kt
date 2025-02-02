package io.openads.adsmanager.adaccount.input.rest.v1.aduser

import io.openads.adsmanager.adaccount.domain.entity.AdUser
import io.openads.adsmanager.adaccount.domain.vo.UserId

data class AdUserResponseV1(
    val userId: UserId,
    val name: String,
    val email: String,
) {
    companion object {
        fun from(adUser: AdUser) = AdUserResponseV1(
            userId = adUser.userId,
            name = adUser.name,
            email = adUser.email,
        )
    }
}
