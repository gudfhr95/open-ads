package io.openads.adsmanager.adaccount.port.mail

interface MailPort {
    fun sendMail(
        email: String,
        title: String,
        content: String,
    )
}
