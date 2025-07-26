package io.openads.adsmanager.adaccount.domain.entity

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.openads.adsmanager.adaccount.domain.vo.AdAccountId
import io.openads.adsmanager.adaccount.domain.vo.AdAccountStatus
import io.openads.adsmanager.adaccount.domain.vo.AdUserId
import java.util.UUID

class AdAccountTest : FunSpec({

    test("create ad account with factory method should set PENDING_VERIFICATION status") {
        // Given
        val adAccountId = AdAccountId(UUID.randomUUID().toString())
        val ownerId = AdUserId(UUID.randomUUID().toString())
        val name = "Test Account"

        // When
        val account = AdAccount.create(
            adAccountId = adAccountId,
            ownerId = ownerId,
            name = name,
        )

        // Then
        account.adAccountId shouldBe adAccountId
        account.ownerId shouldBe ownerId
        account.name shouldBe name
        account.status shouldBe AdAccountStatus.PENDING_VERIFICATION
        account.parentAccountId shouldBe null
        account.billingInfo shouldBe null
    }

    test("create ad account with parent account and billing info") {
        // Given
        val adAccountId = AdAccountId(UUID.randomUUID().toString())
        val ownerId = AdUserId(UUID.randomUUID().toString())
        val parentAccountId = AdAccountId(UUID.randomUUID().toString())
        val name = "Test Account"
        val billingInfo = """{"company": "Test Company", "address": "123 Test St"}"""

        // When
        val account = AdAccount.create(
            adAccountId = adAccountId,
            ownerId = ownerId,
            name = name,
            parentAccountId = parentAccountId,
            billingInfo = billingInfo,
        )

        // Then
        account.parentAccountId shouldBe parentAccountId
        account.billingInfo shouldBe billingInfo
    }

    test("account name validation - blank name should throw exception") {
        // Given
        val adAccountId = AdAccountId(UUID.randomUUID().toString())
        val ownerId = AdUserId(UUID.randomUUID().toString())
        val blankName = " "

        // When & Then
        val exception = shouldThrow<IllegalArgumentException> {
            AdAccount.create(
                adAccountId = adAccountId,
                ownerId = ownerId,
                name = blankName,
            )
        }

        exception.message shouldBe "Account name cannot be blank"
    }

    test("account name validation - empty name should throw exception") {
        // Given
        val adAccountId = AdAccountId(UUID.randomUUID().toString())
        val ownerId = AdUserId(UUID.randomUUID().toString())
        val emptyName = ""

        // When & Then
        val exception = shouldThrow<IllegalArgumentException> {
            AdAccount.create(
                adAccountId = adAccountId,
                ownerId = ownerId,
                name = emptyName,
            )
        }

        exception.message shouldBe "Account name cannot be blank"
    }

    test("account name validation - name too long should throw exception") {
        // Given
        val adAccountId = AdAccountId(UUID.randomUUID().toString())
        val ownerId = AdUserId(UUID.randomUUID().toString())
        val longName = "a".repeat(101) // 101 characters

        // When & Then
        val exception = shouldThrow<IllegalArgumentException> {
            AdAccount.create(
                adAccountId = adAccountId,
                ownerId = ownerId,
                name = longName,
            )
        }

        exception.message shouldBe "Account name must be between 1 and 100 characters"
    }

    test("billing info validation - blank billing info should throw exception") {
        // Given
        val adAccountId = AdAccountId(UUID.randomUUID().toString())
        val ownerId = AdUserId(UUID.randomUUID().toString())
        val name = "Test Account"
        val blankBillingInfo = " "

        // When & Then
        val exception = shouldThrow<IllegalArgumentException> {
            AdAccount.create(
                adAccountId = adAccountId,
                ownerId = ownerId,
                name = name,
                billingInfo = blankBillingInfo,
            )
        }

        exception.message shouldBe "Billing info cannot be blank if provided"
    }

    test("activate account from PENDING_VERIFICATION status") {
        // Given
        val account = AdAccount.create(
            adAccountId = AdAccountId(UUID.randomUUID().toString()),
            ownerId = AdUserId(UUID.randomUUID().toString()),
            name = "Test Account",
        )

        // When
        val activatedAccount = account.activate()

        // Then
        activatedAccount.status shouldBe AdAccountStatus.ACTIVE
        activatedAccount.adAccountId shouldBe account.adAccountId
        activatedAccount.ownerId shouldBe account.ownerId
        activatedAccount.name shouldBe account.name
    }

    test("activate account from non-PENDING_VERIFICATION status should throw exception") {
        // Given
        val account = AdAccount.create(
            adAccountId = AdAccountId(UUID.randomUUID().toString()),
            ownerId = AdUserId(UUID.randomUUID().toString()),
            name = "Test Account",
        ).activate() // Already active

        // When & Then
        val exception = shouldThrow<IllegalArgumentException> {
            account.activate()
        }

        exception.message shouldBe "Can only activate accounts with PENDING_VERIFICATION status"
    }

    test("suspend active account") {
        // Given
        val account = AdAccount.create(
            adAccountId = AdAccountId(UUID.randomUUID().toString()),
            ownerId = AdUserId(UUID.randomUUID().toString()),
            name = "Test Account",
        ).activate()

        // When
        val suspendedAccount = account.suspend()

        // Then
        suspendedAccount.status shouldBe AdAccountStatus.SUSPENDED
    }

    test("suspend non-active account should throw exception") {
        // Given
        val account = AdAccount.create(
            adAccountId = AdAccountId(UUID.randomUUID().toString()),
            ownerId = AdUserId(UUID.randomUUID().toString()),
            name = "Test Account",
        ) // Still PENDING_VERIFICATION

        // When & Then
        val exception = shouldThrow<IllegalArgumentException> {
            account.suspend()
        }

        exception.message shouldBe "Can only suspend accounts with ACTIVE status"
    }

    test("close active account") {
        // Given
        val account = AdAccount.create(
            adAccountId = AdAccountId(UUID.randomUUID().toString()),
            ownerId = AdUserId(UUID.randomUUID().toString()),
            name = "Test Account",
        ).activate()

        // When
        val closedAccount = account.close()

        // Then
        closedAccount.status shouldBe AdAccountStatus.CLOSED
    }

    test("close suspended account") {
        // Given
        val account = AdAccount.create(
            adAccountId = AdAccountId(UUID.randomUUID().toString()),
            ownerId = AdUserId(UUID.randomUUID().toString()),
            name = "Test Account",
        ).activate().suspend()

        // When
        val closedAccount = account.close()

        // Then
        closedAccount.status shouldBe AdAccountStatus.CLOSED
    }

    test("close account with invalid status should throw exception") {
        // Given
        val account = AdAccount.create(
            adAccountId = AdAccountId(UUID.randomUUID().toString()),
            ownerId = AdUserId(UUID.randomUUID().toString()),
            name = "Test Account",
        ) // Still PENDING_VERIFICATION

        // When & Then
        val exception = shouldThrow<IllegalArgumentException> {
            account.close()
        }

        exception.message shouldBe "Can only close accounts with ACTIVE or SUSPENDED status"
    }
})