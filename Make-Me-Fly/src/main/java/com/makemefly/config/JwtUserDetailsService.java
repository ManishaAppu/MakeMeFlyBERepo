package com.makemefly.config;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

       if ("user".equals(username)) {
            return new User("user", "$2a$10$h1e5uwwIRnyYiasxFqbCz.LokMhsywvEJnsaLQVZHPGYLxl7WdI9O", new ArrayList<>());
       }
       else if ("admin".equals(username)) {
            return new User("admin", "$2a$10$h1e5uwwIRnyYiasxFqbCz.LokMhsywvEJnsaLQVZHPGYLxl7WdI9O", new ArrayList<>());
        }
       else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }
}