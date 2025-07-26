package io.openads.adsmanager.adaccount.domain.vo

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import io.kotest.matchers.string.shouldContain
import java.util.UUID

class AdAccountIdTest : BehaviorSpec({
    Given("a valid UUID string") {
        val validUuid = UUID.randomUUID().toString()

        When("creating AdAccountId") {
            val adAccountId = AdAccountId(validUuid)

            Then("it should be created successfully") {
                adAccountId.value shouldBe validUuid
            }
        }
    }

    Given("an invalid UUID string") {
        val invalidUuid = "invalid-uuid"

        When("creating AdAccountId") {
            Then("it should throw IllegalArgumentException") {
                val exception = shouldThrow<IllegalArgumentException> {
                    AdAccountId(invalidUuid)
                }

                exception.message shouldContain "AdAccountId must be a valid UUID format"
            }
        }
    }

    Given("a blank string") {
        val blankString = ""

        When("creating AdAccountId") {
            Then("it should throw IllegalArgumentException") {
                val exception = shouldThrow<IllegalArgumentException> {
                    AdAccountId(blankString)
                }

                exception.message shouldBe "AdAccountId cannot be blank"
            }
        }
    }

    Given("a whitespace string") {
        val whitespaceString = "   "

        When("creating AdAccountId") {
            Then("it should throw IllegalArgumentException") {
                val exception = shouldThrow<IllegalArgumentException> {
                    AdAccountId(whitespaceString)
                }

                exception.message shouldBe "AdAccountId cannot be blank"
            }
        }
    }

    Given("generate method") {
        When("generating a new AdAccountId") {
            val adAccountId1 = AdAccountId.generate()
            val adAccountId2 = AdAccountId.generate()

            Then("it should create a valid AdAccountId") {
                // Should not throw exception
                UUID.fromString(adAccountId1.value)
                UUID.fromString(adAccountId2.value)
            }

            Then("each generated AdAccountId should be unique") {
                adAccountId1.value shouldNotBe adAccountId2.value
            }
        }
    }

    Given("edge case UUIDs") {
        val validFormats = listOf(
            "550e8400-e29b-41d4-a716-446655440000", // Standard UUID
            "6ba7b810-9dad-11d1-80b4-00c04fd430c8", // Version 1 UUID
            "6ba7b811-9dad-11d1-80b4-00c04fd430c8"  // Another valid UUID
        )

        When("creating AdAccountId with each format") {
            Then("all should be accepted") {
                validFormats.forEach { uuid ->
                    val adAccountId = AdAccountId(uuid)
                    adAccountId.value shouldBe uuid
                }
            }
        }
    }

    Given("malformed UUID strings") {
        val invalidFormats = listOf(
            "550e8400-e29b-41d4-a716",              // Too short
            "550e8400-e29b-41d4-a716-446655440000-extra", // Too long
            "gggggggg-gggg-gggg-gggg-gggggggggggg", // Invalid characters
            "550e8400e29b41d4a716446655440000"      // Missing hyphens
        )

        When("creating AdAccountId with each invalid format") {
            Then("all should throw IllegalArgumentException") {
                invalidFormats.forEach { invalidUuid ->
                    val exception = shouldThrow<IllegalArgumentException> {
                        AdAccountId(invalidUuid)
                    }
                    exception.message shouldContain "AdAccountId must be a valid UUID format"
                }
            }
        }
    }
})