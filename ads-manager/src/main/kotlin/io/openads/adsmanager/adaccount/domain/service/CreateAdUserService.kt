package io.openads.adsmanager.adaccount.domain.service

import io.openads.adsmanager.adaccount.domain.entity.AdUser
import io.openads.adsmanager.adaccount.domain.event.AdUserCreated
import io.openads.adsmanager.adaccount.domain.repository.AdUserRepository
import io.openads.adsmanager.adaccount.domain.vo.UserId
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service

@Service
class CreateAdUserService(
    private val adUserRepository: AdUserRepository,
    private val eventPublisher: ApplicationEventPublisher,
) {
    operator fun invoke(
        userId: UserId,
        name: String,
        email: String,
    ): AdUser {
        check(!adUserRepository.existsByUserId(userId)) {
            "User already exists"
        }

        val adUser = adUserRepository.save(
            AdUser.of(
                userId = userId,
                name = name,
                email = email,
            ),
        )

        eventPublisher.publishEvent(
            AdUserCreated(
                userId = adUser.userId,
                name = adUser.name,
                email = adUser.email,
            ),
        )

        return adUser
    }
}
