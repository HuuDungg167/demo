package com.hutech.demo.config;

import com.hutech.demo.service.UserService;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final UserService userService;

    @Bean
    public UserDetailsService userDetailsService() {
        return userService;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        var auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userDetailsService());
        auth.setPasswordEncoder(passwordEncoder());
        return auth;
    }


//    @Bean
//    public SecurityFilterChain securityFilterChain(@NotNull HttpSecurity http) throws Exception {
//        return http
//                .authorizeHttpRequests(auth -> auth
//                        // Allow Swagger UI and API docs
//                        .requestMatchers("/swagger-ui/**", "/v3/api-docs/**", "/swagger-ui.html").permitAll()
////
////                        // Publicly accessible URLs
////                                .requestMatchers("/css/**", "/js/**", "/", "/oauth/**", "/register", "/login", "/error", "/index",
////                                        "/about", "/service", "/bookings/**", "/services/**", "/reviews/**").permitAll()
////                                .requestMatchers("/services/create").permitAll()
////
////                        // Admin-only URLs
////                        .requestMatchers("/product/edit/**", "/product/add", "/product/delete", "/api/products", "/users", "/users/edit", "/users/delete").hasAuthority("ADMIN")
////
////                        // User-only URLs
////                        .requestMatchers("/products", "/cart", "/cart/**", "/booking").hasAuthority("USER")
//
//                        // All other requests require authentication
////                        .anyRequest().authenticated()
//                )
////                .logout(logout -> logout
////                        .logoutUrl("/logout")
////                        .logoutSuccessUrl("/login")
////                        .deleteCookies("JSESSIONID")
////                        .invalidateHttpSession(true)
////                        .clearAuthentication(true)
////                        .permitAll()
////                )
////                .formLogin(formLogin -> formLogin
////                        .loginPage("/login")
////                        .loginProcessingUrl("/login")
////                        .defaultSuccessUrl("/index", true)
////                        .failureUrl("/login?error")
////                        .permitAll()
////                )
//                .build();
//    }
    @Bean
    public SecurityFilterChain noAuthSecurityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf.disable()) // Disable CSRF if needed
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/swagger-ui/**", "/v3/api-docs/**", "/swagger-ui.html").permitAll()
                        .anyRequest().permitAll() // Allow all requests
                )
                .build();
    }
}
