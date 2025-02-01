package io.openads.adsmanager.adaccount.domain.service

import io.openads.adsmanager.adaccount.domain.entity.AdUser
import io.openads.adsmanager.adaccount.domain.port.AdUserMessagePort
import io.openads.adsmanager.adaccount.domain.repository.AdUserRepository
import io.openads.adsmanager.common.domain.vo.UserId
import org.springframework.stereotype.Service

@Service
class CreateAdUserService(
    private val adUserRepository: AdUserRepository,
    private val adUserMessagePort: AdUserMessagePort,
) {
    suspend operator fun invoke(
        userId: UserId,
        name: String,
    ): AdUser {
        check(!adUserRepository.existsByUserId(userId)) {
            "User already exists"
        }

        val adUser = adUserRepository.save(
            AdUser.of(
                userId = userId,
                name = name,
            ),
        )

        adUserMessagePort.sendAdUserCreatedMessage(userId)

        return adUser
    }
}
