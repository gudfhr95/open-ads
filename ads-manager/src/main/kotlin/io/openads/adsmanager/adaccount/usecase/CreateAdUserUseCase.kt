package io.openads.adsmanager.adaccount.usecase

import io.openads.adsmanager.adaccount.domain.service.CreateAdUserService
import io.openads.adsmanager.common.domain.vo.UserId
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CreateAdUserUseCase(
    private val createAdUser: CreateAdUserService,
) {
    @Transactional
    suspend operator fun invoke(
        userId: UserId,
        name: String,
    ) = createAdUser(
        userId = userId,
        name = name,
    )
}
