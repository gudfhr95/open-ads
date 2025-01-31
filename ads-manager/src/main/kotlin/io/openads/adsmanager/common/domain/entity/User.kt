package io.openads.adsmanager.common.domain.entity

import io.openads.adsmanager.common.domain.vo.UserId

abstract class User(
    val userId: UserId,
    val name: String,
) : UpdatableEntity()
