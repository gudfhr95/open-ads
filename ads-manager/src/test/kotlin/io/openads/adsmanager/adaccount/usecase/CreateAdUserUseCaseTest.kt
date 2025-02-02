package io.openads.adsmanager.adaccount.usecase

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import io.mockk.verify
import io.openads.adsmanager.adaccount.domain.event.AdUserCreated
import io.openads.adsmanager.adaccount.domain.vo.AdUserId
import io.openads.adsmanager.test.spec.IntegrationTestSpec
import org.springframework.context.ApplicationEventPublisher
import java.util.UUID

class CreateAdUserUseCaseTest(
    private val createAdUserUseCase: CreateAdUserUseCase,
    private val eventPublisher: ApplicationEventPublisher,
) : IntegrationTestSpec({
    Given("valid adUserId, name and email") {
        val adUserId = AdUserId(UUID.randomUUID().toString())
        val name = "name"
        val email = "email@test.com"

        When("create a user") {
            val user = createAdUserUseCase(
                adUserId = adUserId,
                name = name,
                email = email,
            )

            Then("it should return a user") {
                user.adUserId shouldBe adUserId
                user.name shouldBe name
                user.email shouldBe email
            }

            Then("it should publish AdUserCreated event") {
                verify {
                    eventPublisher.publishEvent(
                        AdUserCreated(
                            adUserId = adUserId,
                            name = name,
                            email = email,
                        ),
                    )
                }
            }

            And("create same user again") {
                Then("it should throw exception") {
                    val exception = shouldThrow<IllegalStateException> {
                        createAdUserUseCase(
                            adUserId = adUserId,
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
        val adUserId = AdUserId(UUID.randomUUID().toString())
        val name = " "
        val email = "email@test.com"

        When("create a user") {
            Then("it should throw exception") {
                val exception = shouldThrow<IllegalArgumentException> {
                    createAdUserUseCase(
                        adUserId = adUserId,
                        name = name,
                        email = email,
                    )
                }

                exception.message shouldBe "Name cannot be blank"
            }
        }
    }

    Given("invalid email") {
        val adUserId = AdUserId(UUID.randomUUID().toString())
        val name = "name"
        val email = "email"

        When("create a user") {
            Then("it should throw exception") {
                val exception = shouldThrow<IllegalArgumentException> {
                    createAdUserUseCase(
                        adUserId = adUserId,
                        name = name,
                        email = email,
                    )
                }

                exception.message shouldBe "Email must be valid"
            }
        }
    }
})
