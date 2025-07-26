package io.openads.adsmanager.adaccount.domain.vo

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class MemberRoleTest : FunSpec({

    context("canManageMembers") {
        test("OWNER should be able to manage members") {
            MemberRole.OWNER.canManageMembers() shouldBe true
        }

        test("ADMIN should be able to manage members") {
            MemberRole.ADMIN.canManageMembers() shouldBe true
        }

        test("EDITOR should not be able to manage members") {
            MemberRole.EDITOR.canManageMembers() shouldBe false
        }

        test("VIEWER should not be able to manage members") {
            MemberRole.VIEWER.canManageMembers() shouldBe false
        }
    }

    context("canEditCampaigns") {
        test("OWNER should be able to edit campaigns") {
            MemberRole.OWNER.canEditCampaigns() shouldBe true
        }

        test("ADMIN should be able to edit campaigns") {
            MemberRole.ADMIN.canEditCampaigns() shouldBe true
        }

        test("EDITOR should be able to edit campaigns") {
            MemberRole.EDITOR.canEditCampaigns() shouldBe true
        }

        test("VIEWER should not be able to edit campaigns") {
            MemberRole.VIEWER.canEditCampaigns() shouldBe false
        }
    }

    context("canViewReports") {
        test("OWNER should be able to view reports") {
            MemberRole.OWNER.canViewReports() shouldBe true
        }

        test("ADMIN should be able to view reports") {
            MemberRole.ADMIN.canViewReports() shouldBe true
        }

        test("EDITOR should be able to view reports") {
            MemberRole.EDITOR.canViewReports() shouldBe true
        }

        test("VIEWER should be able to view reports") {
            MemberRole.VIEWER.canViewReports() shouldBe true
        }
    }
})