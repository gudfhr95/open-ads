package io.openads.adsmanager.adaccount.domain.service

import io.openads.adsmanager.adaccount.domain.entity.AdUser
import io.openads.adsmanager.adaccount.domain.repository.AdUserRepository
import io.openads.adsmanager.common.domain.vo.UserId
import org.springframework.stereotype.Service

@Service
class CreateAdUserService(
    private val adUserRepository: AdUserRepository,
) {
    suspend operator fun invoke(userId: String) {
        adUserRepository.save(
            AdUser.of(
                userId = UserId(userId),
                name = "User $userId",
            ),
        )
    }
}
