package io.openads.adsmanager.adaccount.input.rest.v1.aduser

import io.openads.adsmanager.adaccount.domain.entity.AdUser

data class AdUserResponseV1(
    val userId: String,
    val name: String,
) {
    companion object {
        fun from(adUser: AdUser) = AdUserResponseV1(
            userId = adUser.userId.value,
            name = adUser.name,
        )
    }
}
