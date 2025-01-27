package io.openads.adsmanager.config.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity
import org.springframework.security.config.web.server.ServerHttpSecurity
import org.springframework.security.web.server.SecurityWebFilterChain

@Configuration
@EnableWebFluxSecurity
class SecurityConfig {
    @Bean
    fun securityWebFilterChain(http: ServerHttpSecurity): SecurityWebFilterChain = http
        .authorizeExchange {
            it.anyExchange().authenticated()
        }
        .oauth2ResourceServer {
            it.jwt {
                it.jwtAuthenticationConverter(JwtAuthenticationConverter())
            }
        }
        .csrf { it.disable() }
        .build()
}
