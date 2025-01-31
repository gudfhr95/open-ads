package io.openads.adsmanager.adaccount.domain.entity

import io.openads.adsmanager.common.domain.entity.User
import io.openads.adsmanager.common.domain.vo.UserId
import org.springframework.data.relational.core.mapping.Table

@Table("ad_users")
class AdUser(
    userId: UserId,
    name: String,
) : User(
    userId = userId,
    name = name,
) {
    companion object {
        fun of(
            userId: UserId,
            name: String,
        ) = AdUser(
            userId = userId,
            name = name,
        )
    }
}
