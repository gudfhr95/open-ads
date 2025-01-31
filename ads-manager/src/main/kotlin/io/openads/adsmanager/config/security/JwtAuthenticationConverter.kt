package io.openads.adsmanager.config.security

import kotlinx.coroutines.reactor.mono
import org.springframework.core.convert.converter.Converter
import org.springframework.security.authentication.AbstractAuthenticationToken
import org.springframework.security.core.authority.AuthorityUtils
import org.springframework.security.oauth2.jwt.Jwt
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken
import reactor.core.publisher.Mono

class JwtAuthenticationConverter : Converter<Jwt, Mono<AbstractAuthenticationToken>> {
    override fun convert(jwt: Jwt): Mono<AbstractAuthenticationToken> = mono {
        JwtAuthenticationToken(
            jwt,
            AuthorityUtils.createAuthorityList(),
            jwt.claims["name"].toString(),
        )
//        val user = User.of(
//            userId = jwt.subject,
//        )
//
//        UsernamePasswordAuthenticationToken(
//            user,
//            null,
//            AuthorityUtils.createAuthorityList(),
//        )
    }
}
