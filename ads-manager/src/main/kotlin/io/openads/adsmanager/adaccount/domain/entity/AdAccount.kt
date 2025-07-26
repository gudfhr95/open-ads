package io.openads.adsmanager.adaccount.domain.entity

import io.openads.adsmanager.adaccount.domain.vo.AdAccountId
import io.openads.adsmanager.adaccount.domain.vo.AdAccountStatus
import io.openads.adsmanager.adaccount.domain.vo.AdUserId
import io.openads.adsmanager.shared.domain.entity.UpdatableEntity
import org.springframework.data.relational.core.mapping.Table

@Table("ad_accounts")
class AdAccount(
    val adAccountId: AdAccountId,
    val ownerId: AdUserId,
    val name: String,
    val status: AdAccountStatus,
    val parentAccountId: AdAccountId? = null,
    val billingInfo: String? = null,
) : UpdatableEntity() {

    companion object {
        fun create(
            adAccountId: AdAccountId,
            ownerId: AdUserId,
            name: String,
            parentAccountId: AdAccountId? = null,
            billingInfo: String? = null,
        ) = AdAccount(
            adAccountId = adAccountId,
            ownerId = ownerId,
            name = name,
            status = AdAccountStatus.PENDING_VERIFICATION,
            parentAccountId = parentAccountId,
            billingInfo = billingInfo,
        )
    }

    init {
        require(name.isNotBlank()) { "Account name cannot be blank" }
        require(name.length in 1..100) { "Account name must be between 1 and 100 characters" }
        billingInfo?.let {
            require(it.isNotBlank()) { "Billing info cannot be blank if provided" }
        }
    }

    fun activate(): AdAccount {
        require(status == AdAccountStatus.PENDING_VERIFICATION) {
            "Can only activate accounts with PENDING_VERIFICATION status"
        }
        return copy(status = AdAccountStatus.ACTIVE)
    }

    fun suspend(): AdAccount {
        require(status == AdAccountStatus.ACTIVE) {
            "Can only suspend accounts with ACTIVE status"
        }
        return copy(status = AdAccountStatus.SUSPENDED)
    }

    fun close(): AdAccount {
        require(status in listOf(AdAccountStatus.ACTIVE, AdAccountStatus.SUSPENDED)) {
            "Can only close accounts with ACTIVE or SUSPENDED status"
        }
        return copy(status = AdAccountStatus.CLOSED)
    }

    private fun copy(
        adAccountId: AdAccountId = this.adAccountId,
        ownerId: AdUserId = this.ownerId,
        name: String = this.name,
        status: AdAccountStatus = this.status,
        parentAccountId: AdAccountId? = this.parentAccountId,
        billingInfo: String? = this.billingInfo,
    ) = AdAccount(
        adAccountId = adAccountId,
        ownerId = ownerId,
        name = name,
        status = status,
        parentAccountId = parentAccountId,
        billingInfo = billingInfo,
    )
}