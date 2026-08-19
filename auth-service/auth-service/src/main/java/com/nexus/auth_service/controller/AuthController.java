package com.nexus.auth_service.controller;

import com.nexus.auth_service.dto.LoginRequestDTO;
import com.nexus.auth_service.dto.AuthResponseDTO;
import com.nexus.auth_service.dto.UserRequestDTO;
import com.nexus.auth_service.entity.User;
import com.nexus.auth_service.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public String addNewUser(@RequestBody UserRequestDTO request) {
        return authService.saveUser(request);
    }

    @PostMapping("/login")
    public AuthResponseDTO getToken(@RequestBody LoginRequestDTO request) {
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        if (authenticate.isAuthenticated()) {
            String token = authService.generateToken(request.getEmail());
            User user = authService.getUserByEmail(request.getEmail());
            return new AuthResponseDTO(token, user.getName(), user.getJobRole());
        } else {
            throw new RuntimeException("invalid access");
        }
    }
}
