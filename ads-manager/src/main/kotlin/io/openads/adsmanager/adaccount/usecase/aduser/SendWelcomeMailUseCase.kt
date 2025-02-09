package io.openads.adsmanager.adaccount.usecase.aduser

import io.openads.adsmanager.adaccount.port.mail.MailPort
import org.springframework.stereotype.Service

@Service
class SendWelcomeMailUseCase(
    private val mailPort: MailPort,
) {
    operator fun invoke(email: String) {
        mailPort.sendMail(
            email = email,
            title = "Welcome",
            content = "Welcome to Open Ads",
        )
    }
}
