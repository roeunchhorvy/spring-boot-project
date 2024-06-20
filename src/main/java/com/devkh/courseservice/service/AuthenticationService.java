package com.devkh.courseservice.service;

import com.devkh.courseservice.model.LoginUserDto;
import com.devkh.courseservice.model.RegisterUserDto;
import com.devkh.courseservice.model.UserInfm;
import com.devkh.courseservice.repository.UserInfmRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    private final UserInfmRepository userInfmRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    public AuthenticationService(

            UserInfmRepository userInfmRepository, AuthenticationManager authenticationManager,
            PasswordEncoder passwordEncoder
    ) {
        this.userInfmRepository = userInfmRepository;
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
    }

    public UserInfm signup(RegisterUserDto input) {
        UserInfm userInfm = new UserInfm();
        userInfm.setFullName(input.getFullName());
        userInfm.setEmail(input.getEmail());
        userInfm.setPassword(passwordEncoder.encode(input.getPassword()));

        return userInfmRepository.save(userInfm);
    }

    public UserInfm authenticate(LoginUserDto input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getEmail(),
                        input.getPassword()
                )
        );

        return userInfmRepository.findByEmail(input.getEmail())
                .orElseThrow();
    }
}
