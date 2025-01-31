package io.openads.adsmanager.adaccount.input.rest.v1.aduser

import org.springframework.test.web.reactive.server.WebTestClient

fun WebTestClient.createAdUser() = post()
    .uri("/v1/ad-users")
    .exchange()
