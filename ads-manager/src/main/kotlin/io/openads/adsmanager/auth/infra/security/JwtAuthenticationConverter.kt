package io.openads.adsmanager.auth.infra.security

import org.springframework.core.convert.converter.Converter
import org.springframework.security.authentication.AbstractAuthenticationToken
import org.springframework.security.core.authority.AuthorityUtils
import org.springframework.security.oauth2.jwt.Jwt
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken

class JwtAuthenticationConverter : Converter<Jwt, AbstractAuthenticationToken> {
    override fun convert(jwt: Jwt): AbstractAuthenticationToken {
        return JwtAuthenticationToken(
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
