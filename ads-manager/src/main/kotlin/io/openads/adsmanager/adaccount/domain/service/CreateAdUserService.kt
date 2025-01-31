package io.openads.adsmanager.adaccount.domain.service

import io.openads.adsmanager.adaccount.domain.entity.AdUser
import io.openads.adsmanager.adaccount.domain.repository.AdUserRepository
import io.openads.adsmanager.common.domain.vo.UserId
import org.springframework.stereotype.Service

@Service
class CreateAdUserService(
    private val adUserRepository: AdUserRepository,
) {
    suspend operator fun invoke(
        userId: UserId,
        name: String,
    ): AdUser {
        check(!adUserRepository.existsByUserId(userId)) {
            "User already exists"
        }

        return adUserRepository.save(
            AdUser.of(
                userId = userId,
                name = name,
            ),
        )
    }
}
