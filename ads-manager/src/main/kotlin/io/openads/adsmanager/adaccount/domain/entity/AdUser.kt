package io.openads.adsmanager.adaccount.domain.entity

import io.openads.adsmanager.adaccount.domain.vo.AdUserId
import io.openads.adsmanager.shared.domain.entity.UpdatableEntity
import org.springframework.data.relational.core.mapping.Table

@Table("ad_users")
class AdUser(
    val adUserId: AdUserId,
    val name: String,
    val email: String,
) : UpdatableEntity() {
    companion object {
        fun of(
            adUserId: AdUserId,
            name: String,
            email: String,
        ) = AdUser(
            adUserId = adUserId,
            name = name,
            email = email,
        )
    }

    init {
        require(name.isNotBlank()) { "Name cannot be blank" }
        require(email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\$".toRegex())) { "Email must be valid" }
    }
}
