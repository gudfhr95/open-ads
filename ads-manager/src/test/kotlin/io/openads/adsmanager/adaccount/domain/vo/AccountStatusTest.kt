package io.openads.adsmanager.adaccount.domain.vo

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class AccountStatusTest : FunSpec({

    context("isOperational") {
        test("PENDING_VERIFICATION should not be operational") {
            AccountStatus.PENDING_VERIFICATION.isOperational() shouldBe false
        }

        test("ACTIVE should be operational") {
            AccountStatus.ACTIVE.isOperational() shouldBe true
        }

        test("SUSPENDED should not be operational") {
            AccountStatus.SUSPENDED.isOperational() shouldBe false
        }

        test("TERMINATED should not be operational") {
            AccountStatus.TERMINATED.isOperational() shouldBe false
        }
    }

    context("enum values") {
        test("should have all expected status values") {
            val expectedStatuses = setOf(
                AccountStatus.PENDING_VERIFICATION,
                AccountStatus.ACTIVE,
                AccountStatus.SUSPENDED,
                AccountStatus.TERMINATED
            )
            
            AccountStatus.values().toSet() shouldBe expectedStatuses
        }
    }
})