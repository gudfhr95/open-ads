package io.openads.adsmanager.adaccount.domain.entity

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import io.openads.adsmanager.adaccount.domain.vo.AdAccountId
import io.openads.adsmanager.adaccount.domain.vo.AdUserId
import io.openads.adsmanager.adaccount.domain.vo.MemberRole
import java.time.Instant
import java.util.UUID

class AdAccountMemberTest : FunSpec({

    test("should create pending member invitation") {
        // Given
        val adAccountId = AdAccountId(UUID.randomUUID().toString())
        val adUserId = AdUserId(UUID.randomUUID().toString())
        val invitedBy = AdUserId(UUID.randomUUID().toString())
        val role = MemberRole.EDITOR

        // When
        val member = AdAccountMember.invite(
            adAccountId = adAccountId,
            adUserId = adUserId,
            role = role,
            invitedBy = invitedBy
        )

        // Then
        member.adAccountId shouldBe adAccountId
        member.adUserId shouldBe adUserId
        member.role shouldBe role
        member.invitedBy shouldBe invitedBy
        member.acceptedAt shouldBe null
        member.isPending() shouldBe true
        member.isAccepted() shouldBe false
    }

    test("should accept invitation") {
        // Given
        val member = AdAccountMember.invite(
            adAccountId = AdAccountId(UUID.randomUUID().toString()),
            adUserId = AdUserId(UUID.randomUUID().toString()),
            role = MemberRole.VIEWER,
            invitedBy = AdUserId(UUID.randomUUID().toString())
        )

        // When
        val beforeAccept = Instant.now()
        member.accept()
        val afterAccept = Instant.now()

        // Then
        member.acceptedAt shouldNotBe null
        member.acceptedAt!! shouldBe >= beforeAccept
        member.acceptedAt!! shouldBe <= afterAccept
        member.isPending() shouldBe false
        member.isAccepted() shouldBe true
    }

    test("should update member role") {
        // Given
        val member = AdAccountMember.invite(
            adAccountId = AdAccountId(UUID.randomUUID().toString()),
            adUserId = AdUserId(UUID.randomUUID().toString()),
            role = MemberRole.VIEWER,
            invitedBy = AdUserId(UUID.randomUUID().toString())
        )

        // When
        member.updateRole(MemberRole.ADMIN)

        // Then
        member.role shouldBe MemberRole.ADMIN
    }

    test("should maintain invitation state when updating role") {
        // Given
        val member = AdAccountMember.invite(
            adAccountId = AdAccountId(UUID.randomUUID().toString()),
            adUserId = AdUserId(UUID.randomUUID().toString()),
            role = MemberRole.VIEWER,
            invitedBy = AdUserId(UUID.randomUUID().toString())
        )

        // When
        member.accept()
        val originalAcceptedAt = member.acceptedAt
        member.updateRole(MemberRole.ADMIN)

        // Then
        member.role shouldBe MemberRole.ADMIN
        member.acceptedAt shouldBe originalAcceptedAt
        member.isAccepted() shouldBe true
    }

    test("should handle multiple role updates") {
        // Given
        val member = AdAccountMember.invite(
            adAccountId = AdAccountId(UUID.randomUUID().toString()),
            adUserId = AdUserId(UUID.randomUUID().toString()),
            role = MemberRole.VIEWER,
            invitedBy = AdUserId(UUID.randomUUID().toString())
        )

        // When & Then
        member.updateRole(MemberRole.EDITOR)
        member.role shouldBe MemberRole.EDITOR

        member.updateRole(MemberRole.ADMIN)
        member.role shouldBe MemberRole.ADMIN

        member.updateRole(MemberRole.VIEWER)
        member.role shouldBe MemberRole.VIEWER
    }
})