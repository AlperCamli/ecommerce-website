package com.nature.Nature.service;

import com.nature.Nature.Model.User;
import com.nature.Nature.Repository.UserRepository;
import com.nature.Nature.Security.JwtUtil;
import com.nature.Nature.Service.AuthService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AuthServiceTests {
    private AuthService authService;
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private JwtUtil jwtUtil;

    @BeforeEach
    public void setUp() {
        userRepository = mock(UserRepository.class);
        passwordEncoder = mock(PasswordEncoder.class);
        jwtUtil = mock(JwtUtil.class);
        authService = new AuthService(userRepository, passwordEncoder, jwtUtil);
    }

    @Test
    public void register_success() {
        User user = new User();
        user.setEmail("test@example.com");
        user.setPassword("pass");

        when(userRepository.findByEmail("test@example.com")).thenReturn(Optional.empty());
        when(passwordEncoder.encode("pass")).thenReturn("encoded");

        String result = authService.register(user);
        assertEquals("User registered successfully", result);
        verify(userRepository).save(user);
    }

    @Test
    public void login_success() {
        User user = new User();
        user.setEmail("test@example.com");
        user.setPassword("encoded");

        when(userRepository.findByEmail("test@example.com")).thenReturn(Optional.of(user));
        when(passwordEncoder.matches("pass", "encoded")).thenReturn(true);
        when(jwtUtil.generateToken("test@example.com")).thenReturn("token");

        String token = authService.login("test@example.com", "pass");
        assertEquals("token", token);
    }

    @Test
    public void login_invalidCredentials() {
        when(userRepository.findByEmail("missing@example.com")).thenReturn(Optional.empty());
        assertThrows(RuntimeException.class, () -> authService.login("missing@example.com", "pass"));
    }
}
