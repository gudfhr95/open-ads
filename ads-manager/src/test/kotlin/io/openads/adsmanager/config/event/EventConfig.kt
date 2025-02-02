package io.openads.adsmanager.config.event

import io.mockk.every
import io.mockk.just
import io.mockk.mockk
import io.mockk.runs
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.ApplicationEventPublisher
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Primary

@TestConfiguration
class EventConfig {
    @Bean
    @Primary
    fun applicationEventPublisher() = mockk<ApplicationEventPublisher> {
        every { publishEvent(any(Object::class)) } just runs
    }
}
