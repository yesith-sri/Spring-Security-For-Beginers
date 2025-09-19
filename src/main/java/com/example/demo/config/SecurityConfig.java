package com.example.demo.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.password.CompromisedPasswordChecker;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.password.HaveIBeenPwnedRestApiPasswordChecker;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {

//    @Bean
//    public UserDetailsService userDetailsService() {
//
//        /** Create a user with username "user" and password "password" */
//        UserDetails user1 = User.withUsername("user1")
//                .password("{bcrypt}password") // {noop} means no encoding
//                .build();
//
//        UserDetails user2 = User.withUsername("user2")
//                .password("{bcrypt}password") // {noop} means no encoding
//                .build();
//
//        /** Use in-memory user store */
//        return new InMemoryUserDetailsManager(user1, user2);
//    }


    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http
                /** Disable CSRF (for testing APIs / Postman) */
                .csrf(AbstractHttpConfigurer::disable)

                /** Set URL access rules */
                .authorizeHttpRequests(requests ->
                        requests
                                /** Allow anyone to access /hello */
                                .requestMatchers("/hello", "/register/**").permitAll()

                                /** Require login for /test/** */
                                .requestMatchers("/test/**" ).authenticated()
                )

                /** Enable default login form (/login) */
                .formLogin(withDefaults())

                /** Enable HTTP Basic auth (for APIs/Postman) */
                .httpBasic(withDefaults());

        /** Build security chain */
        return http.build();
    }


    @Bean
    PasswordEncoder passwordEncoder() {
        // return new BCryptPasswordEncoder();
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
//
//    @Bean
//    public CompromisedPasswordChecker compromisedPasswordChecker() {
//            return new HaveIBeenPwnedRestApiPasswordChecker();
//    }
}
