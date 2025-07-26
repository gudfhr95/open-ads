package io.openads.adsmanager.adaccount.domain.vo

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class BudgetTypeTest : FunSpec({

    test("should have DAILY budget type") {
        BudgetType.DAILY.name shouldBe "DAILY"
    }

    test("should have LIFETIME budget type") {
        BudgetType.LIFETIME.name shouldBe "LIFETIME"
    }

    test("should have exactly two budget types") {
        BudgetType.values().size shouldBe 2
    }
})