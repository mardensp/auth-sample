package com.sample.authsample.config;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RoleConverter implements Converter<Jwt, Collection<GrantedAuthority>> {

    @Override
    public Collection<GrantedAuthority> convert(Jwt source) {

        Map<String, Object> realmAccess = (Map<String, Object>) source.getClaims().get("realm_access");

        return ((List<String>) realmAccess.get("roles")).stream().map(role -> {
            return new SimpleGrantedAuthority(role);
        }).collect(Collectors.toList());
    }
}
