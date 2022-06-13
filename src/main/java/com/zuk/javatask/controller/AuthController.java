package com.zuk.javatask.controller;


import com.zuk.javatask.dto.AuthDto;
import com.zuk.javatask.entity.Person;
import com.zuk.javatask.entity.Role;
import com.zuk.javatask.security.JwtTokenProvider;
import com.zuk.javatask.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.AuthenticationException;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/auth/")
@Slf4j
public class AuthController {

    private final PersonService personService;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;

    @Autowired
    public AuthController(PersonService personService, AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider) {
        this.personService = personService;
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @PostMapping("login")
    public ResponseEntity login(@RequestBody AuthDto requestDto) {

        Map<Object, Object> response = new HashMap<>();
        try {
            String username = requestDto.getUsername();
            Person user = personService.findByUsername(username);

            if (user == null) {
                response.put("success", false);
                response.put("message", "Username not found");
                return ResponseEntity.ok(response);
            }

            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, requestDto.getPassword()));
            List<String> roles = new ArrayList<>();
            roles.add(String.valueOf(user.getRole()));

            String token = jwtTokenProvider.createToken(username, roles);
            response.put("success", true);
            response.put("username", username);
            response.put("user_id",user.getId());

            response.put("role",jwtTokenProvider.getRoleNames(roles));
            response.put("token", token);
            return ResponseEntity.ok(response);
        } catch (AuthenticationException e) {
            response.put("success", false);
            response.put("message", "Bad Credentials");
            return ResponseEntity.ok(response);
        }


    }
}
