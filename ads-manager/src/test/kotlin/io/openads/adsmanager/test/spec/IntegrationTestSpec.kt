package io.openads.adsmanager.test.spec

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.extensions.spring.SpringExtension
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.testcontainers.service.connection.ServiceConnection
import org.testcontainers.containers.MySQLContainer

@SpringBootTest
abstract class IntegrationTestSpec(
    body: BehaviorSpec.() -> Unit,
) : BehaviorSpec(body) {
    companion object {
        @ServiceConnection
        private val mysql = MySQLContainer("mysql:8.4")
    }

    override fun extensions() = listOf(SpringExtension)
}
