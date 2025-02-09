package io.openads.adsmanager.shared.domain.entity

import org.springframework.data.annotation.LastModifiedBy
import org.springframework.data.annotation.LastModifiedDate
import java.time.Instant

abstract class UpdatableEntity : BaseEntity() {
    @LastModifiedDate
    val updatedAt: Instant = Instant.now()

    @LastModifiedBy
    val updatedBy: String = "SYSTEM"
}
