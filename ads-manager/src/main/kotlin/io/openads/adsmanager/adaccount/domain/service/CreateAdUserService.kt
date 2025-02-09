package io.openads.adsmanager.adaccount.domain.service

import io.openads.adsmanager.adaccount.domain.entity.AdUser
import io.openads.adsmanager.adaccount.domain.event.AdUserCreatedV1
import io.openads.adsmanager.adaccount.domain.repository.AdUserRepository
import io.openads.adsmanager.adaccount.domain.vo.AdUserId
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service

@Service
class CreateAdUserService(
    private val adUserRepository: AdUserRepository,
    private val eventPublisher: ApplicationEventPublisher,
) {
    operator fun invoke(
        adUserId: AdUserId,
        name: String,
        email: String,
    ): AdUser {
        check(!adUserRepository.existsByAdUserId(adUserId)) {
            "User already exists"
        }

        val adUser = adUserRepository.save(
            AdUser.of(
                adUserId = adUserId,
                name = name,
                email = email,
            ),
        )

        eventPublisher.publishEvent(
            AdUserCreatedV1(
                adUserId = adUser.adUserId,
                name = adUser.name,
                email = adUser.email,
            ),
        )

        return adUser
    }
}
