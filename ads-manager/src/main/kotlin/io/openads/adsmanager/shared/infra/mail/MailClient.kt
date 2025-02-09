package io.openads.adsmanager.shared.infra.mail

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class MailClient {
    private val logger = LoggerFactory.getLogger(this::class.java)

    fun sendMail(
        email: String,
        title: String,
        content: String,
    ) {
        logger.info("Send mail to $email")
        logger.info("Title: $title, Content: $content")
    }
}
