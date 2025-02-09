package io.openads.adsmanager.adaccount.usecase.aduser

import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import io.mockk.just
import io.mockk.runs
import io.mockk.verify
import io.openads.adsmanager.adaccount.port.mail.MailPort
import io.openads.adsmanager.test.spec.IntegrationTestSpec

class SendWelcomeMailUseCaseTest(
    private val sendWelcomeMail: SendWelcomeMailUseCase,
    @MockkBean
    private val mailPort: MailPort,
) : IntegrationTestSpec({
    every { mailPort.sendMail(any(), any(), any()) } just runs

    Given("a email") {
        val email = "email@test.com"

        When("send welcome mail") {
            sendWelcomeMail(email)

            Then("mail should be sent") {
                verify(exactly = 1) { mailPort.sendMail(email, any(), any()) }
            }
        }
    }
})
