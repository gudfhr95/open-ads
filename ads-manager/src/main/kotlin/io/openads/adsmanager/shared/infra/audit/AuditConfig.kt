package io.openads.adsmanager.shared.infra.audit

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.domain.AuditorAware
import org.springframework.data.jdbc.repository.config.EnableJdbcAuditing
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.oauth2.jwt.JwtAuthenticationToken
import java.util.*

@Configuration
@EnableJdbcAuditing(auditorAwareRef = "auditorAware")
class AuditConfig {

    @Bean
    fun auditorAware(): AuditorAware<String> = AuditorAware {
        val authentication = SecurityContextHolder.getContext().authentication
        when (authentication) {
            is JwtAuthenticationToken -> Optional.of(authentication.name)
            null -> Optional.of("SYSTEM")
            else -> Optional.of(authentication.name ?: "SYSTEM")
        }
    }
}