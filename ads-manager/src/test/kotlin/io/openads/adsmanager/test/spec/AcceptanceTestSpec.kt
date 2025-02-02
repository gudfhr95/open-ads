package io.openads.adsmanager.test.spec

import io.kotest.core.spec.style.BehaviorSpec
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
abstract class AcceptanceTestSpec(
    body: BehaviorSpec.() -> Unit,
) : IntegrationTestSpec(body)
