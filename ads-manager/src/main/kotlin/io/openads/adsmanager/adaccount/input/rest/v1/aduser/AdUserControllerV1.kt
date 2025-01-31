package io.openads.adsmanager.adaccount.input.rest.v1.aduser

import io.openads.adsmanager.adaccount.usecase.CreateAdUserUseCase
import io.openads.adsmanager.common.domain.vo.UserId
import org.springframework.http.HttpStatus
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/ad-users")
class AdUserControllerV1(
    private val createAdUser: CreateAdUserUseCase,
) {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    suspend fun create(
        authentication: JwtAuthenticationToken,
    ): AdUserResponseV1 {
        val adUser = createAdUser(
            userId = UserId(authentication.token.subject),
            name = authentication.name,
        )

        return AdUserResponseV1.from(adUser)
    }
}
