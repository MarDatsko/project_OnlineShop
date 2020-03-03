package com.project.shop.security;

import com.project.shop.dto.AccountDto;
import com.project.shop.dto.UserDto;
import com.project.shop.service.AccountService;
import com.project.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;


@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {

    private final UserService userService;
    private final AccountService accountService;

    @Autowired
    public JwtUserDetailsServiceImpl(UserService userService, AccountService accountService) {
        this.userService = userService;
        this.accountService = accountService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDto user = userService.findByAccount_UserName(username);
        Long accountId = userService.findByAccount_UserName(username).getId();
        AccountDto account = accountService.getById(accountId);

        if (user == null) {
            throw new UsernameNotFoundException("Invalid User");
        } else {
            Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
            SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(user.getRole());
            grantedAuthorities.add(simpleGrantedAuthority);

            return new org.springframework.security.core.userdetails
                    .User(account.getUserName(), account.getPassword(), grantedAuthorities);
        }
    }
}
