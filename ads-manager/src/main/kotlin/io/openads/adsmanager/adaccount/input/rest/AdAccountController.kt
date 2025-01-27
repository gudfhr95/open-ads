package io.openads.adsmanager.adaccount.input.rest

import io.openads.adsmanager.adaccount.usecase.CreateAdAccountUseCase
import io.openads.adsmanager.common.domain.entity.User
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/ad-accounts")
class AdAccountController(
    private val createAdAccount: CreateAdAccountUseCase,
) {
    @PostMapping
    suspend fun create(
        @AuthenticationPrincipal user: User,
    ) {
        createAdAccount()
    }
}
