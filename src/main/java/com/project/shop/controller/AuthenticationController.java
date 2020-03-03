package com.project.shop.controller;

import com.project.shop.dto.UserDto;
import com.project.shop.security.AuthenticationRequest;
import com.project.shop.security.AuthenticationResponse;
import com.project.shop.security.JwtUtil;
import com.project.shop.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final JwtUtil jwtUtil;

    @Autowired
    public AuthenticationController(AuthenticationManager authenticationManager, UserService userService, JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody AuthenticationRequest request) {
        String username = request.getUsername();
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, request.getPassword()));
        UserDto userDto = userService.findByAccount_UserName(username);

        if (userDto == null) {
            throw new UsernameNotFoundException("User not found");
        }

        String token = jwtUtil.createToken(username, userDto.getRole());
        AuthenticationResponse response = new AuthenticationResponse(token);

        return ResponseEntity.ok(response);
    }
}
