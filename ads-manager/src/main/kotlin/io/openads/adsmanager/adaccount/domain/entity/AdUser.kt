package io.openads.adsmanager.adaccount.domain.entity

import io.openads.adsmanager.adaccount.domain.vo.UserId
import io.openads.adsmanager.common.domain.entity.UpdatableEntity
import org.springframework.data.relational.core.mapping.Table

@Table("ad_users")
class AdUser(
    val userId: UserId,
    val name: String,
    val email: String,
) : UpdatableEntity() {
    companion object {
        fun of(
            userId: UserId,
            name: String,
            email: String,
        ) = AdUser(
            userId = userId,
            name = name,
            email = email,
        )
    }

    init {
        require(name.isNotBlank()) { "Name cannot be blank" }
    }
}
