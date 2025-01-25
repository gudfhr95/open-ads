package io.openads.adsmanager.adaccount.application

import org.springframework.stereotype.Service

@Service
class CreateAdAccountUseCase {
    suspend operator fun invoke() {
        println("Creating ad account")
    }
}
