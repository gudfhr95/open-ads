package io.openads.adsmanager.config.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity
import org.springframework.security.config.web.server.ServerHttpSecurity
import org.springframework.security.web.server.SecurityWebFilterChain

@Configuration
@EnableWebFluxSecurity
class SecurityConfig(
    private val jwtAuthenticationManager: JwtAuthenticationManager,
) {
    @Bean
    fun securityWebFilterChain(http: ServerHttpSecurity): SecurityWebFilterChain =
        http
            .authorizeExchange {
                it.anyExchange().authenticated()
            }.oauth2ResourceServer { resourceServer ->
                resourceServer.jwt { jwt ->
                    jwt.authenticationManager(jwtAuthenticationManager)
                }
            }.logout { }
            .csrf { it.disable() }
            .build()
}
