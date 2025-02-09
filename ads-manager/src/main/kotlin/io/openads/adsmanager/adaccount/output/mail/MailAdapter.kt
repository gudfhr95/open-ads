package io.openads.adsmanager.adaccount.output.mail

import io.openads.adsmanager.adaccount.port.mail.MailPort
import io.openads.adsmanager.shared.infra.mail.MailClient
import org.springframework.stereotype.Component

@Component
class MailAdapter(
    private val mailClient: MailClient,
) : MailPort {
    override fun sendMail(
        email: String,
        title: String,
        content: String,
    ) {
        mailClient.sendMail(
            email = email,
            title = title,
            content = content,
        )
    }
}
