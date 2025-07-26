package io.openads.adsmanager.adaccount.domain.vo

enum class AccountStatus {
    PENDING_VERIFICATION,
    ACTIVE,
    SUSPENDED,
    TERMINATED;

    fun isOperational(): Boolean = this == ACTIVE
}