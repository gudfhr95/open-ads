package io.openads.adsmanager.test.extension

import io.kotest.core.listeners.AfterTestListener
import io.kotest.core.listeners.BeforeTestListener
import io.kotest.core.test.TestCase
import io.kotest.core.test.TestResult
import org.springframework.security.core.authority.AuthorityUtils
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.oauth2.jwt.Jwt
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken
import java.util.UUID

class MockJwtExtension(
    private val userId: String = UUID.randomUUID().toString(),
    private val username: String = "name",
    private val email: String = "email@test.com",
) : BeforeTestListener,
    AfterTestListener {
    override suspend fun beforeTest(testCase: TestCase) {
        val jwt = Jwt.withTokenValue("token")
            .header("alg", "none")
            .subject(userId)
            .claim("name", username)
            .claim("email", email)
            .build()

        val token = JwtAuthenticationToken(
            jwt,
            AuthorityUtils.createAuthorityList(),
            username,
        )

        val context = SecurityContextHolder.createEmptyContext()
        context.authentication = token

        SecurityContextHolder.setContext(context)
    }

    override suspend fun afterTest(testCase: TestCase, result: TestResult) {
        SecurityContextHolder.clearContext()
    }
}
