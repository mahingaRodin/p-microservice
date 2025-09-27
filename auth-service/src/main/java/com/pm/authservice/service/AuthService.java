package com.pm.authservice.service;

import com.pm.authservice.dto.LoginRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.pm.authservice.util.JwtUtil;

import java.util.Optional;

@Service
public class AuthService {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public AuthService(UserService userService, PasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }
    public Optional<String> authenticate(LoginRequestDTO loginRequestDTO) {
        Optional<String> token = userService
                .findByEmail(loginRequestDTO.getEmail())
                .filter(u -> {
                    boolean matches = passwordEncoder.matches(loginRequestDTO.getPassword(), u.getPassword());
                    System.out.println("Password matches? " + matches);
                    return matches;
                })
                .map(u -> jwtUtil.generateToken(u.getEmail(), u.getRole()));

    return token;
}}
