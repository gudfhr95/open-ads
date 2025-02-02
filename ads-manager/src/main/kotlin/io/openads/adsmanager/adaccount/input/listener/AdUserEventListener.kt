package io.openads.adsmanager.adaccount.input.listener

import io.openads.adsmanager.adaccount.domain.event.AdUserCreated
import org.springframework.modulith.events.ApplicationModuleListener
import org.springframework.stereotype.Component

@Component
class AdUserEventListener {
    @ApplicationModuleListener
    fun onAdUserCreated(event: AdUserCreated) {
        println("Ad user created: ${event.userId} - ${event.name}")
    }
}
