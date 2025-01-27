package io.openads.adsmanager.config.security

import io.openads.adsmanager.common.domain.entity.User
import kotlinx.coroutines.reactor.mono
import org.springframework.core.convert.converter.Converter
import org.springframework.security.authentication.AbstractAuthenticationToken
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.authority.AuthorityUtils
import org.springframework.security.oauth2.jwt.Jwt
import reactor.core.publisher.Mono

class JwtAuthenticationConverter : Converter<Jwt, Mono<AbstractAuthenticationToken>> {
    override fun convert(jwt: Jwt): Mono<AbstractAuthenticationToken> = mono {
        val user = User.of(
            id = jwt.subject,
        )

        UsernamePasswordAuthenticationToken(
            user,
            null,
            AuthorityUtils.createAuthorityList(),
        )
    }
}
