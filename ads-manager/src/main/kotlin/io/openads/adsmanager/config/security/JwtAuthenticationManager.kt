package io.openads.adsmanager.config.security

import kotlinx.coroutines.reactor.mono
import org.casbin.casdoor.service.AuthService
import org.springframework.security.authentication.ReactiveAuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.authority.AuthorityUtils
import org.springframework.security.core.context.ReactiveSecurityContextHolder
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono

@Component
class JwtAuthenticationManager(
    val authService: AuthService,
) : ReactiveAuthenticationManager {
    override fun authenticate(authentication: Authentication): Mono<Authentication> =
        mono {
            val jwt = authentication.name
            val user = authService.parseJwtToken(jwt)

            val authenticationToken =
                UsernamePasswordAuthenticationToken(
                    user,
                    null,
                    AuthorityUtils.createAuthorityList("ROLE_casdoor"),
                )

            ReactiveSecurityContextHolder.withAuthentication(authenticationToken)

            authenticationToken
        }
}
