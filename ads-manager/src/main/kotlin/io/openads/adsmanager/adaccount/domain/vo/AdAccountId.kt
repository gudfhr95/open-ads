package io.openads.adsmanager.adaccount.domain.vo

import java.util.UUID

@JvmInline
value class AdAccountId(val value: String) {
    init {
        require(value.isNotBlank()) { "AdAccountId cannot be blank" }
        try {
            UUID.fromString(value)
        } catch (e: IllegalArgumentException) {
            throw IllegalArgumentException("AdAccountId must be a valid UUID format", e)
        }
    }

    companion object {
        fun generate(): AdAccountId = AdAccountId(UUID.randomUUID().toString())
    }
}