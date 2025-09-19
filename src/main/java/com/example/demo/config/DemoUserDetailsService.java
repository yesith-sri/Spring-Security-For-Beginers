package com.example.demo.config;

import com.example.demo.entity.CustomerEntity;
import com.example.demo.repositary.CustomerRepositary;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DemoUserDetailsService implements UserDetailsService {

    private final CustomerRepositary customerRepositary;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        CustomerEntity customerEntity = customerRepositary.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User details not found for the given credentials"));

        /**  This line takes the role from the database (e.g. "ROLE_USER" or "ROLE_ADMIN"),
         wraps it in a SimpleGrantedAuthority object so Spring Security understands it
         as a permission/authority, and then puts it into a list.
         Later, Spring uses this list to check what the user is allowed to access. */
        List<SimpleGrantedAuthority> authorities =
                List.of(new SimpleGrantedAuthority(customerEntity.getRole()));

        return new User(customerEntity.getEmail(), customerEntity.getPassword(), authorities);
    }

}
