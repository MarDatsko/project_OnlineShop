package com.project.shop.controller;

import com.project.shop.dto.AccountDto;
import com.project.shop.dto.RegistrationRequest;
import com.project.shop.dto.UserDto;
import com.project.shop.model.Account;
import com.project.shop.model.Role;
import com.project.shop.model.User;
import com.project.shop.model.UserStatus;
import com.project.shop.security.AuthenticationRequest;
import com.project.shop.security.AuthenticationResponse;
import com.project.shop.security.JwtUtil;
import com.project.shop.service.AccountService;
import com.project.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final AccountService accountService;
    private final UserService userService;
    private final JwtUtil jwtUtil;

    @Autowired
    public AuthenticationController(AuthenticationManager authenticationManager, AccountService accountService, UserService userService, JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.accountService = accountService;
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

    @PostMapping("/registration")
    public ResponseEntity registration(@RequestBody RegistrationRequest request) {
        AccountDto accountFromDB = accountService.getByUserName(request.getUserName());

        if (accountFromDB != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User with that name or email is already create");
        }

        Account account = new Account(request.getUserName(), request.getEmail(), request.getPassword());
        User user = new User(request.getFirstName(), request.getLastName(), request.getAge(), request.getPhone(),
                Role.USER, UserStatus.ACTIVE, account);

        accountService.saveOrUpdate(account);
        userService.saveOrUpdate(user);

        return ResponseEntity.status(HttpStatus.OK).body("All is fine, you have successfully registered");
    }
}
