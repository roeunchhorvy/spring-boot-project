package com.devkh.courseservice.controller;


import com.devkh.courseservice.model.UserInfm;
import com.devkh.courseservice.service.UserInfmService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
@SecurityRequirement(name = "bearerAuth")
public class UserInfmController {
    private final UserInfmService userInfmService;

    public UserInfmController(UserInfmService userInfmService) {
        this.userInfmService = userInfmService;
    }

        @GetMapping("/currentUser")
        public ResponseEntity<UserInfm> authenticatedUser() {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

            UserInfm currentUser = (UserInfm) authentication.getPrincipal();

            return ResponseEntity.ok(currentUser);
        }


    @GetMapping("/allUser")
    public ResponseEntity<List<UserInfm>> allUsers() {
        List <UserInfm> users = userInfmService.allUsers();

        return ResponseEntity.ok(users);
    }
}
