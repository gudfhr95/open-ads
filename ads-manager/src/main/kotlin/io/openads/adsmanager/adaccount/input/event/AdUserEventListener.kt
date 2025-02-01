package io.openads.adsmanager.adaccount.input.event

import io.openads.adsmanager.adaccount.domain.event.AdUserCreated
import kotlinx.coroutines.reactor.mono
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional
import org.springframework.transaction.event.TransactionalEventListener

@Component
class AdUserEventListener {
    @TransactionalEventListener
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    fun onAdUserCreated(event: AdUserCreated) = mono {
        println("Ad user created: ${event.userId} - ${event.name}")
    }
}
