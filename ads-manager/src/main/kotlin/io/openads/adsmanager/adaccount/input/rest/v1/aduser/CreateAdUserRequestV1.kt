package io.openads.adsmanager.adaccount.input.rest.v1.aduser

import jakarta.validation.constraints.NotBlank

data class CreateAdUserRequestV1(
    @field:NotBlank
    val name: String,
)
