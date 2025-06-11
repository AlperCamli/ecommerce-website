package com.nature.Nature.Controllers;

import com.nature.Nature.Model.User;
import com.nature.Nature.Service.AuthService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        return authService.register(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {
        return authService.login(request.getEmail(), request.getPassword());
    }
}

class LoginRequest {
    private String email;
    private String password;

    public String getEmail() { return email; }
    public String getPassword() { return password; }
}
