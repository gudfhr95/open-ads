package io.openads.adsmanager.adaccount.usecase

import io.openads.adsmanager.adaccount.domain.service.CreateAdUserService
import io.openads.adsmanager.adaccount.domain.vo.AdUserId
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CreateAdUserUseCase(
    private val createAdUser: CreateAdUserService,
) {
    @Transactional
    operator fun invoke(
        adUserId: AdUserId,
        name: String,
        email: String,
    ) = createAdUser(
        adUserId = adUserId,
        name = name,
        email = email,
    )
}
