package io.openads.adsmanager.shared.infra.event

import io.openads.adsmanager.adaccount.domain.event.AdUserCreatedV1
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.modulith.events.EventExternalizationConfiguration

@Configuration
class EventConfig {
    @Bean
    fun eventExternalizationConfiguration() = EventExternalizationConfiguration
        .externalizing()
        .select(EventExternalizationConfiguration.annotatedAsExternalized())
        .routeKey(AdUserCreatedV1::class.java) { it.adUserId.value }
        .mapping(AdUserCreatedV1::class.java) { it }
        .build()
}
