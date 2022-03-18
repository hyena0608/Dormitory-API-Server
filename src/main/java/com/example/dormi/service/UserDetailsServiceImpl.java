package com.example.dormi.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    public UserDetails loadUserByUsername(String userPk) {
        CustomUserDetails user = new CustomUserDetails();
        user.setUsername(userPk);
        return user;
    }
}
