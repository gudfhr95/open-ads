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

    test("ADMIN should have manage and edit permissions") {
        // Given
        val role = MemberRole.ADMIN

        // Then
        role.canManageMembers() shouldBe true
        role.canEditCampaigns() shouldBe true
        role.canViewReports() shouldBe true
    }

    test("EDITOR should have edit and view permissions only") {
        // Given
        val role = MemberRole.EDITOR

        // Then
        role.canManageMembers() shouldBe false
        role.canEditCampaigns() shouldBe true
        role.canViewReports() shouldBe true
    }

    test("VIEWER should have view permissions only") {
        // Given
        val role = MemberRole.VIEWER

        // Then
        role.canManageMembers() shouldBe false
        role.canEditCampaigns() shouldBe false
        role.canViewReports() shouldBe true
    }

    test("all roles should have view permissions") {
        // Given & Then
        MemberRole.values().forEach { role ->
            role.canViewReports() shouldBe true
        }
    }

    test("only OWNER and ADMIN should have management permissions") {
        // Given & Then
        val managementRoles = setOf(MemberRole.OWNER, MemberRole.ADMIN)
        MemberRole.values().forEach { role ->
            role.canManageMembers() shouldBe (role in managementRoles)
        }
    }

    test("OWNER, ADMIN, and EDITOR should have edit permissions") {
        // Given & Then
        val editRoles = setOf(MemberRole.OWNER, MemberRole.ADMIN, MemberRole.EDITOR)
        MemberRole.values().forEach { role ->
            role.canEditCampaigns() shouldBe (role in editRoles)
        }
    }
})