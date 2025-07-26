package io.openads.adsmanager.adaccount.domain.vo

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class BudgetTypeTest : FunSpec({

    context("enum values") {
        test("should have DAILY budget type") {
            BudgetType.DAILY.name shouldBe "DAILY"
        }

        test("should have LIFETIME budget type") {
            BudgetType.LIFETIME.name shouldBe "LIFETIME"
        }

        test("should have exactly two budget types") {
            BudgetType.values().size shouldBe 2
        }

        test("should have all expected budget types") {
            val expectedTypes = setOf(
                BudgetType.DAILY,
                BudgetType.LIFETIME
            )
            
            BudgetType.values().toSet() shouldBe expectedTypes
        }
    }
})