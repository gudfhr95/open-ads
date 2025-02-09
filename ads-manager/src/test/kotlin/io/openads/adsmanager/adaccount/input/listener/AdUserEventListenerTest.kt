package io.openads.adsmanager.adaccount.input.listener

import com.ninjasquad.springmockk.MockkBean
import io.mockk.verify
import io.openads.adsmanager.adaccount.domain.event.AdUserCreatedV1
import io.openads.adsmanager.adaccount.domain.vo.AdUserId
import io.openads.adsmanager.adaccount.port.mail.MailPort
import io.openads.adsmanager.test.spec.IntegrationTestSpec
import java.util.UUID

class AdUserEventListenerTest(
    private val adUserEventListener: AdUserEventListener,
    @MockkBean
    private val mailPort: MailPort,
) : IntegrationTestSpec({
    Given("AdUserCreated event") {
        val adUserId = AdUserId(UUID.randomUUID().toString())
        val name = "name"
        val email = "email@test.com"

        val event = AdUserCreatedV1(
            adUserId = adUserId,
            name = name,
            email = email,
        )

        When("publish event") {
            adUserEventListener.onAdUserCreated(event)

            Then("it should send welcome mail") {
                verify(exactly = 1) {
                    mailPort.sendMail(email, any(), any())
                }
            }
        }
    }
})
