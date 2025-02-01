package io.openads.adsmanager.adaccount.usecase

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import io.openads.adsmanager.adaccount.domain.vo.UserId
import io.openads.adsmanager.test.spec.IntegrationTestSpec
import java.util.UUID

class CreateAdUserUseCaseTest(
    private val createAdUserUseCase: CreateAdUserUseCase,
) : IntegrationTestSpec({
    Given("Valid userId and name") {
        val userId = UserId(UUID.randomUUID().toString())
        val name = "name"

        When("create a user") {
            val user = createAdUserUseCase(
                userId = userId,
                name = name,
            )

            Then("should return a user") {
                user.userId shouldBe userId
                user.name shouldBe name
            }

            And("create same user again") {
                Then("it should throw exception") {
                    val exception = shouldThrow<IllegalStateException> {
                        createAdUserUseCase(
                            userId = userId,
                            name = name,
                        )
                    }

                    exception.message shouldBe "User already exists"
                }
            }
        }
    }

    Given("Valid userId and invalid name") {
        val userId = UserId(UUID.randomUUID().toString())
        val name = " "

        When("create a user") {
            Then("it should throw exception") {
                val exception = shouldThrow<IllegalArgumentException> {
                    createAdUserUseCase(
                        userId = userId,
                        name = name,
                    )
                }

                exception.message shouldBe "Name cannot be blank"
            }
        }
    }
})
