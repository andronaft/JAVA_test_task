package com.zuk.javatask.security;


import com.zuk.javatask.entity.Person;
import com.zuk.javatask.entity.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class JwtUserFactory {

    public JwtUserFactory() {
    }

    public static JwtUser create(Person user) {
        List<String> userRoles = new ArrayList<>();
        userRoles.add(String.valueOf(user.getRole()));
        return new JwtUser(
                user.getId(),
                user.getUsername(),
                user.getName(),
                user.getSurname(),
                user.getEmail(),
                user.getPassword(),
                mapToGrantedAuthorities(userRoles)

        );
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(List<String> userRoles) {
        return userRoles.stream()
                .map(role ->
                        new SimpleGrantedAuthority(role)
                ).collect(Collectors.toList());
    }
}