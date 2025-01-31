package io.openads.adsmanager.adaccount.input.rest.v1.aduser

import io.kotest.matchers.shouldBe
import io.openads.adsmanager.test.extension.MockJwtExtension
import io.openads.adsmanager.test.spec.AcceptanceTestSpec
import org.springframework.test.web.reactive.server.WebTestClient
import java.util.UUID

class AdUserControllerV1AcceptanceTest(
    val client: WebTestClient,
) : AcceptanceTestSpec({
    Given("a user with jwt") {
        val userId = UUID.randomUUID().toString()
        val name = "test"

        extensions(MockJwtExtension(userId, name))

        When("the user creates an ad user") {
            Then("the ad user should be created") {
                client.createAdUser()
                    .expectStatus()
                    .isCreated
                    .expectBody(AdUserResponseV1::class.java)
                    .value {
                        it.userId shouldBe userId
                        it.name shouldBe name
                    }
            }

            And("the user creates an ad user again") {
                Then("it should return bad request") {
                    client.createAdUser()
                        .expectStatus()
                        .isBadRequest
                }
            }
        }
    }
})
