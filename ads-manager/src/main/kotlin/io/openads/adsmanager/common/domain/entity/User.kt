package io.openads.adsmanager.common.domain.entity

class User private constructor(
    val id: String,
) {
    companion object {
        fun of(id: String): User = User(id)
    }
}
