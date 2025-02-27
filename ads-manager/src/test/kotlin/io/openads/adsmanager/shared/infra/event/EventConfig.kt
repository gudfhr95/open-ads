package io.openads.adsmanager.shared.infra.event

import io.mockk.spyk
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.ApplicationEventPublisher
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Primary

@TestConfiguration
class EventConfig(
    private val eventPublisher: ApplicationEventPublisher,
) {
    @Bean
    @Primary
    fun applicationEventPublisher() = spyk(eventPublisher)
}
