package io.openads.adsmanager.adaccount.domain.vo

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class MemberRoleTest : FunSpec({

    test("OWNER should have all permissions") {
        // Given
        val role = MemberRole.OWNER

        // Then
        role.canManageMembers() shouldBe true
        role.canEditCampaigns() shouldBe true
        role.canViewReports() shouldBe true
    }

    test("ADMIN should have all permissions") {
        // Given
        val role = MemberRole.ADMIN

        // Then
        role.canManageMembers() shouldBe true
        role.canEditCampaigns() shouldBe true
        role.canViewReports() shouldBe true
    }

    test("EDITOR should have campaign and view permissions but not member management") {
        // Given
        val role = MemberRole.EDITOR

        // Then
        role.canManageMembers() shouldBe false
        role.canEditCampaigns() shouldBe true
        role.canViewReports() shouldBe true
    }

    test("VIEWER should only have view permissions") {
        // Given
        val role = MemberRole.VIEWER

        // Then
        role.canManageMembers() shouldBe false
        role.canEditCampaigns() shouldBe false
        role.canViewReports() shouldBe true
    }

    test("all roles should be able to view reports") {
        // Given & Then
        MemberRole.values().forEach { role ->
            role.canViewReports() shouldBe true
        }
    }

    test("only OWNER and ADMIN can manage members") {
        // Given & Then
        MemberRole.OWNER.canManageMembers() shouldBe true
        MemberRole.ADMIN.canManageMembers() shouldBe true
        MemberRole.EDITOR.canManageMembers() shouldBe false
        MemberRole.VIEWER.canManageMembers() shouldBe false
    }

    test("OWNER, ADMIN, and EDITOR can edit campaigns") {
        // Given & Then
        MemberRole.OWNER.canEditCampaigns() shouldBe true
        MemberRole.ADMIN.canEditCampaigns() shouldBe true
        MemberRole.EDITOR.canEditCampaigns() shouldBe true
        MemberRole.VIEWER.canEditCampaigns() shouldBe false
    }
})