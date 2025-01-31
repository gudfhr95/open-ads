package io.openads.adsmanager.adaccount.input.rest

import io.openads.adsmanager.test.extension.SecurityExtension
import io.openads.adsmanager.test.spec.AcceptanceTestSpec
import org.springframework.test.web.reactive.server.WebTestClient

class AdAccountControllerTest(val client: WebTestClient) :
    AcceptanceTestSpec({
        Given("a user") {
            extensions(SecurityExtension())

            When("the user creates an ad account") {
                Then("the ad account is created") {
                    client
                        .post()
                        .uri("/v1/ad-accounts")
                        .exchange()
                        .expectStatus()
                        .isOk
                }
            }
        }
    })
