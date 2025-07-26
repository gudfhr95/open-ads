package io.openads.adsmanager.adaccount.domain.entity

import io.openads.adsmanager.adaccount.domain.vo.AdAccountId
import io.openads.adsmanager.adaccount.domain.vo.AdUserId
import io.openads.adsmanager.adaccount.domain.vo.MemberRole
import io.openads.adsmanager.shared.domain.entity.BaseEntity
import org.springframework.data.relational.core.mapping.Table
import java.time.Instant

@Table("ad_account_members")
class AdAccountMember private constructor(
    val adAccountId: AdAccountId,
    val adUserId: AdUserId,
    var role: MemberRole,
    val invitedBy: AdUserId,
    var acceptedAt: Instant? = null,
) : BaseEntity() {

    companion object {
        fun invite(
            adAccountId: AdAccountId,
            adUserId: AdUserId,
            role: MemberRole,
            invitedBy: AdUserId
        ) = AdAccountMember(
            adAccountId = adAccountId,
            adUserId = adUserId,
            role = role,
            invitedBy = invitedBy,
            acceptedAt = null
        )
    }

    fun accept() {
        this.acceptedAt = Instant.now()
    }

    fun updateRole(newRole: MemberRole) {
        this.role = newRole
    }

    fun isPending(): Boolean = acceptedAt == null
    
    fun isAccepted(): Boolean = acceptedAt != null
}