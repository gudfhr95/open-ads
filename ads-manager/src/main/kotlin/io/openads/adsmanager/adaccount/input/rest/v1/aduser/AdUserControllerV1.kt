package io.openads.adsmanager.adaccount.input.rest.v1.aduser

import io.openads.adsmanager.adaccount.usecase.CreateAdUserUseCase
import jakarta.validation.Valid
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.oauth2.jwt.Jwt
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
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
        @RequestBody @Valid request: CreateAdUserRequestV1,
    ) {
        createAdUser(jwt.subject)
    }
}
