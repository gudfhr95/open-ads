package io.openads.adsmanager.adaccount.input.rest.v1

import io.openads.adsmanager.adaccount.usecase.CreateAdUserUseCase
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.oauth2.jwt.Jwt
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/ad-users")
class AdUserControllerV1(
    private val createAdUser: CreateAdUserUseCase,
) {
    @PostMapping
    suspend fun create(
        @AuthenticationPrincipal jwt: Jwt,
    ) {
        createAdUser(jwt.subject)
    }
}
