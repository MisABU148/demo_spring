package com.example.demo.configurations;

import com.example.demo.services.CustomUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final CustomUserDetailsService userDetailsService;
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(5);
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/product/**", "/images/**", "/registration").permitAll() // Разрешить доступ к указанным путям
                        .requestMatchers("/").authenticated() // Все остальные запросы требуют аутентификации
                        .anyRequest().authenticated() // Все остальные запросы требуют аутентификации
                )
                .formLogin(AbstractAuthenticationFilterConfigurer::permitAll
//                        (form) -> form
//                        .loginPage("/login") // Страница входа
//                        .defaultSuccessUrl("/hello") // Перенаправление после успешного входа
//                        .permitAll()
                )
                //.logout((logout) -> logout.permitAll())
                .build();

        return http.build();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
            DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
            provider.setUserDetailsService(userDetailsService());
            provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

//    @Bean
//    public AuthenticationManager authenticationManager(
//            AuthenticationConfiguration authenticationConfiguration) throws Exception {
//        return authenticationConfiguration.getAuthenticationManager();
//    }
    @Bean
    public UserDetailsService userDetailsService() {
        return this.userDetailsService;
    }
}
