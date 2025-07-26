package io.openads.adsmanager.adaccount.domain.entity

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import io.openads.adsmanager.adaccount.domain.vo.AdAccountId
import io.openads.adsmanager.adaccount.domain.vo.AdUserId
import io.openads.adsmanager.adaccount.domain.vo.MemberRole
import java.time.Instant
import java.util.*

class AdAccountMemberTest : FunSpec({

    test("should create pending member with invite factory method") {
        // Given
        val adAccountId = AdAccountId(UUID.randomUUID().toString())
        val adUserId = AdUserId(UUID.randomUUID().toString())
        val role = MemberRole.EDITOR
        val invitedBy = "owner@test.com"

        // When
        val member = AdAccountMember.invite(adAccountId, adUserId, role, invitedBy)

        // Then
        member.adAccountId shouldBe adAccountId
        member.adUserId shouldBe adUserId
        member.role shouldBe role
        member.acceptedAt shouldBe null
        member.createdBy shouldBe invitedBy
        member.isPending() shouldBe true
        member.isAccepted() shouldBe false
    }

    test("should accept invitation and set acceptedAt timestamp") {
        // Given
        val member = AdAccountMember.invite(
            AdAccountId(UUID.randomUUID().toString()),
            AdUserId(UUID.randomUUID().toString()),
            MemberRole.VIEWER,
            "owner@test.com"
        )
        val beforeAccept = Instant.now()

        // When
        member.accept()

        // Then
        member.acceptedAt shouldNotBe null
        member.acceptedAt!! >= beforeAccept shouldBe true
        member.isPending() shouldBe false
        member.isAccepted() shouldBe true
    }

    test("should update member role") {
        // Given
        val member = AdAccountMember.invite(
            AdAccountId(UUID.randomUUID().toString()),
            AdUserId(UUID.randomUUID().toString()),
            MemberRole.VIEWER,
            "owner@test.com"
        )

        // When
        member.updateRole(MemberRole.EDITOR)

        // Then
        member.role shouldBe MemberRole.EDITOR
    }

    test("should correctly identify pending status") {
        // Given
        val member = AdAccountMember.invite(
            AdAccountId(UUID.randomUUID().toString()),
            AdUserId(UUID.randomUUID().toString()),
            MemberRole.ADMIN,
            "owner@test.com"
        )

        // Then
        member.isPending() shouldBe true
        member.isAccepted() shouldBe false
    }

    test("should correctly identify accepted status after acceptance") {
        // Given
        val member = AdAccountMember.invite(
            AdAccountId(UUID.randomUUID().toString()),
            AdUserId(UUID.randomUUID().toString()),
            MemberRole.ADMIN,
            "owner@test.com"
        )

        // When
        member.accept()

        // Then
        member.isPending() shouldBe false
        member.isAccepted() shouldBe true
    }
})