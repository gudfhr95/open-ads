package io.openads.adsmanager.adaccount.input.rest.v1.aduser

import jakarta.validation.constraints.NotBlank

data class CreateAdUserRequestV1(
    @field:NotBlank(
        message = "Name must not be blank",
    )
    val name: String,
)
