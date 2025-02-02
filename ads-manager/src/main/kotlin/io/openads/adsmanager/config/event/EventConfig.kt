package io.openads.adsmanager.config.event

import io.openads.adsmanager.adaccount.domain.event.AdUserCreated
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.modulith.events.EventExternalizationConfiguration

@Configuration
class EventConfig {
    @Bean
    fun eventExternalizationConfiguration() = EventExternalizationConfiguration
        .externalizing()
        .select(EventExternalizationConfiguration.annotatedAsExternalized())
        .routeKey(AdUserCreated::class.java) { it.adUserId.value }
        .mapping(AdUserCreated::class.java) { it }
        .build()
}
