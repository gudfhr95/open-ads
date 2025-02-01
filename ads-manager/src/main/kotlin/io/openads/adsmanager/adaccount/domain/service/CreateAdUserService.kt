package io.openads.adsmanager.adaccount.domain.service

import io.openads.adsmanager.adaccount.domain.entity.AdUser
import io.openads.adsmanager.adaccount.domain.event.AdUserCreated
import io.openads.adsmanager.adaccount.domain.repository.AdUserRepository
import io.openads.adsmanager.common.domain.vo.UserId
import kotlinx.coroutines.reactor.awaitSingleOrNull
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service
import org.springframework.transaction.reactive.TransactionalEventPublisher

@Service
class CreateAdUserService(
    private val eventPublisher: ApplicationEventPublisher,
    private val adUserRepository: AdUserRepository,
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

        TransactionalEventPublisher(eventPublisher).publishEvent(
            AdUserCreated(
                userId = userId,
                name = name,
            ),
        ).awaitSingleOrNull()

        return adUser
    }
}
