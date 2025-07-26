package io.openads.adsmanager.adaccount.domain.entity

import io.openads.adsmanager.adaccount.domain.vo.AdAccountId
import io.openads.adsmanager.adaccount.domain.vo.AdUserId
import io.openads.adsmanager.adaccount.domain.vo.MemberRole
import io.openads.adsmanager.shared.domain.entity.BaseEntity
import org.springframework.data.relational.core.mapping.Table
import java.time.Instant

@Table("ad_account_members")
class AdAccountMember(
    val adAccountId: AdAccountId,
    val adUserId: AdUserId,
    var role: MemberRole,
    var acceptedAt: Instant? = null,
    id: Long = 0L,
    createdAt: Instant = Instant.now(),
    createdBy: String = "SYSTEM"
) : BaseEntity(id, createdAt, createdBy) {

    fun accept() {
        acceptedAt = Instant.now()
    }

    fun updateRole(newRole: MemberRole) {
        role = newRole
    }

    fun isPending(): Boolean = acceptedAt == null

    fun isAccepted(): Boolean = acceptedAt != null

    companion object {
        fun invite(
            adAccountId: AdAccountId,
            adUserId: AdUserId,
            role: MemberRole,
            invitedBy: String
        ): AdAccountMember {
            return AdAccountMember(
                adAccountId = adAccountId,
                adUserId = adUserId,
                role = role,
                acceptedAt = null,
                createdBy = invitedBy
            )
        }
    }
}