package io.openads.adsmanager.adaccount.usecase

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import io.openads.adsmanager.adaccount.domain.vo.UserId
import io.openads.adsmanager.test.spec.IntegrationTestSpec
import java.util.UUID

class CreateAdUserUseCaseTest(
    private val createAdUserUseCase: CreateAdUserUseCase,
) : IntegrationTestSpec({
    Given("valid userId, name and email") {
        val userId = UserId(UUID.randomUUID().toString())
        val name = "name"
        val email = "email@test.com"

        When("create a user") {
            val user = createAdUserUseCase(
                userId = userId,
                name = name,
                email = email,
            )

            Then("should return a user") {
                user.userId shouldBe userId
                user.name shouldBe name
                user.email shouldBe email
            }

            And("create same user again") {
                Then("it should throw exception") {
                    val exception = shouldThrow<IllegalStateException> {
                        createAdUserUseCase(
                            userId = userId,
                            name = name,
                            email = email,
                        )
                    }

                    exception.message shouldBe "User already exists"
                }
            }
        }
    }

    Given("invalid name") {
        val userId = UserId(UUID.randomUUID().toString())
        val name = " "
        val email = "email@test.com"

        When("create a user") {
            Then("it should throw exception") {
                val exception = shouldThrow<IllegalArgumentException> {
                    createAdUserUseCase(
                        userId = userId,
                        name = name,
                        email = email,
                    )
                }

                exception.message shouldBe "Name cannot be blank"
            }
        }
    }

    Given("invalid email") {
        val userId = UserId(UUID.randomUUID().toString())
        val name = "name"
        val email = "email"

        When("create a user") {
            Then("it should throw exception") {
                val exception = shouldThrow<IllegalArgumentException> {
                    createAdUserUseCase(
                        userId = userId,
                        name = name,
                        email = email,
                    )
                }

                exception.message shouldBe "Email must be valid"
            }
        }
    }
})
