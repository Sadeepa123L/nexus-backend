package com.nexus.auth_service.service;

import com.nexus.auth_service.dto.UserRequestDTO;
import com.nexus.auth_service.entity.AuthProvider;
import com.nexus.auth_service.entity.User;
import com.nexus.auth_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    public String saveUser(UserRequestDTO request) {
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setJobRole(request.getJobRole());
        user.setAuthProvider(AuthProvider.LOCAL);
        userRepository.save(user);
        return "User added to the system";
    }

    public String generateToken(String email) {
        return jwtService.generateToken(email);
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }
}
