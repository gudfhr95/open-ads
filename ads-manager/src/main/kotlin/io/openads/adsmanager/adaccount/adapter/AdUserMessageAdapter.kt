package io.openads.adsmanager.adaccount.adapter

import io.openads.adsmanager.adaccount.domain.port.AdUserMessagePort
import io.openads.adsmanager.adaccount.domain.vo.UserId
import kotlinx.coroutines.reactor.awaitSingle
import org.springframework.kafka.core.reactive.ReactiveKafkaProducerTemplate
import org.springframework.stereotype.Component

@Component
class AdUserMessageAdapter(
    private val kafkaTemplate: ReactiveKafkaProducerTemplate<String, String>,
) : AdUserMessagePort {
    override suspend fun sendAdUserCreatedMessage(userId: UserId) {
        kafkaTemplate.send(
            "ad-user-created",
            userId.value.toString(),
        ).awaitSingle()
    }
}
