package io.openads.adsmanager.adaccount.domain.vo

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class AccountStatusTest : FunSpec({

    context("isOperational") {
        test("ACTIVE should be operational") {
            AccountStatus.ACTIVE.isOperational() shouldBe true
        }

        test("PENDING_VERIFICATION should not be operational") {
            AccountStatus.PENDING_VERIFICATION.isOperational() shouldBe false
        }

        test("SUSPENDED should not be operational") {
            AccountStatus.SUSPENDED.isOperational() shouldBe false
        }

        test("TERMINATED should not be operational") {
            AccountStatus.TERMINATED.isOperational() shouldBe false
        }
    }
})