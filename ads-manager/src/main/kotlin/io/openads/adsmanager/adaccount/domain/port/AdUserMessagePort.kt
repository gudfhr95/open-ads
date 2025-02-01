package io.openads.adsmanager.adaccount.domain.port

import io.openads.adsmanager.common.domain.vo.UserId
import org.springframework.stereotype.Component

@Component
interface AdUserMessagePort {
    suspend fun sendAdUserCreatedMessage(userId: UserId)
}
