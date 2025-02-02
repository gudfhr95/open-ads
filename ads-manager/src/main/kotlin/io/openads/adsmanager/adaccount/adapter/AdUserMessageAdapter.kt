package io.openads.adsmanager.adaccount.adapter

import io.openads.adsmanager.adaccount.domain.port.AdUserMessagePort
import io.openads.adsmanager.adaccount.domain.vo.UserId
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
class AdUserMessageAdapter(
    private val kafkaTemplate: KafkaTemplate<String, String>,
) : AdUserMessagePort {
    override fun sendAdUserCreatedMessage(userId: UserId) {
        kafkaTemplate.send(
            "ad-user-created",
            userId.value.toString(),
        )
    }
}
