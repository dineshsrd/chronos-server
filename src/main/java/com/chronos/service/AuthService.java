package com.chronos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.chronos.model.UserModel;
import com.chronos.repository.UserRepository;

@Service
public class AuthService {
    @Autowired
    private UserRepository _userRepository;

    @Autowired
    private PasswordEncoder _passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    public UserDetails authenticate(UserModel input) throws Exception {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getEmail(),
                        input.getPassword()
                )
        );

        return _userRepository.findByEmail(input.getEmail())
                .orElseThrow();
    }
}