package io.openads.adsmanager.adaccount.input.listener

import io.openads.adsmanager.adaccount.domain.event.AdUserCreatedV1
import io.openads.adsmanager.adaccount.usecase.aduser.SendWelcomeMailUseCase
import org.springframework.modulith.events.ApplicationModuleListener
import org.springframework.stereotype.Component

@Component
class AdUserEventListener(
    private val sendWelcomeMail: SendWelcomeMailUseCase,
) {
    @ApplicationModuleListener
    fun onAdUserCreated(event: AdUserCreatedV1) {
        sendWelcomeMail(event.email)
    }
}
