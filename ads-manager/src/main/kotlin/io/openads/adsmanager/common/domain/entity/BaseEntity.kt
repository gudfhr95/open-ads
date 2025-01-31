package io.openads.adsmanager.common.domain.entity

import org.springframework.data.annotation.CreatedBy
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import java.time.Instant

abstract class BaseEntity(
    @Id
    var id: Long = 0L,

    @CreatedDate
    val createdAt: Instant = Instant.now(),

    @CreatedBy
    val createdBy: String = "SYSTEM",
)
