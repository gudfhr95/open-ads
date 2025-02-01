package io.openads.adsmanager.adaccount.input.event

import io.openads.adsmanager.adaccount.domain.event.AdUserCreated
import kotlinx.coroutines.reactor.mono
import org.springframework.modulith.events.ApplicationModuleListener
import org.springframework.stereotype.Component

@Component
class AdUserEventListener {
    @ApplicationModuleListener
    fun onAdUserCreated(event: AdUserCreated) = mono {
        println("Ad user created: ${event.userId} - ${event.name}")
    }
}
