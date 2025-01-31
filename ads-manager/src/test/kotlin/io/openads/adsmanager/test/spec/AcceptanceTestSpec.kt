package io.openads.adsmanager.test.spec

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.extensions.spring.SpringExtension
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
abstract class AcceptanceTestSpec(
    body: BehaviorSpec.() -> Unit,
) : BehaviorSpec(body) {
    override fun extensions() = listOf(SpringExtension)
}
