package io.openads.adsmanager.shared.input.rest.v1

import java.time.Instant

data class ErrorResponseV1(
    val timestamp: Instant = Instant.now(),
    val status: Int,
    val error: String,
    val path: String,
    val requestId: String,
    val messages: List<String>,
)
