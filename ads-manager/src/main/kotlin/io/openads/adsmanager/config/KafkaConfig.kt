package io.openads.adsmanager.config

import org.springframework.boot.autoconfigure.kafka.KafkaProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.core.reactive.ReactiveKafkaProducerTemplate
import reactor.kafka.sender.SenderOptions

@Configuration
class KafkaConfig(
    private val properties: KafkaProperties,
) {
    @Bean
    fun reactiveKafkaProducerTemplate() = ReactiveKafkaProducerTemplate<String, String>(
        SenderOptions.create(properties.buildProducerProperties()),
    )
}
