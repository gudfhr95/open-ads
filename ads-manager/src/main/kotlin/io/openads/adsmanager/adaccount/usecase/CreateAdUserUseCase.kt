package io.openads.adsmanager.adaccount.usecase

import io.openads.adsmanager.adaccount.domain.service.CreateAdUserService
import org.springframework.stereotype.Service

@Service
class CreateAdUserUseCase(
    private val createAdUser: CreateAdUserService,
) {
    suspend operator fun invoke(userId: String) {
        createAdUser(userId)
    }
}
