package io.openads.adsmanager.test.extension

import io.kotest.core.listeners.AfterTestListener
import io.kotest.core.listeners.BeforeTestListener
import io.kotest.core.test.TestCase
import io.kotest.core.test.TestResult
import io.openads.adsmanager.adaccount.domain.entity.AdUser
import io.openads.adsmanager.common.domain.vo.UserId
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.authority.AuthorityUtils
import org.springframework.security.core.context.SecurityContextHolder

class SecurityExtension(
    private val id: String = "1",
    private val roles: List<String> = emptyList(),
) : BeforeTestListener,
    AfterTestListener {
    override suspend fun beforeTest(testCase: TestCase) {
        val authorities = AuthorityUtils.createAuthorityList(roles)
        val user = AdUser.of(
            userId = UserId(id),
            name = "test",
        )

        val token = UsernamePasswordAuthenticationToken(
            user,
            null,
            authorities,
        )

        val context = SecurityContextHolder.createEmptyContext()
        context.authentication = token

        SecurityContextHolder.setContext(context)
    }

    override suspend fun afterTest(testCase: TestCase, result: TestResult) {
        SecurityContextHolder.clearContext()
    }
}
