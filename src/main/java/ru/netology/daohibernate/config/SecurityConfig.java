package ru.netology.daohibernate.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public InMemoryUserDetailsManager userDetailsService() {
    UserDetails user1 = User.withUsername("user1")
            .password(passwordEncoder().encode("user1Pass"))
            .authorities("USER")
            .build();
    UserDetails user2 = User.withUsername("user2")
            .password(passwordEncoder().encode("user2Pass"))
            .authorities("USER")
            .build();
    UserDetails admin = User.withUsername("admin")
            .password(passwordEncoder().encode("adminPass"))
            .authorities("ADMIN")
            .build();
    return new InMemoryUserDetailsManager(user1, user2, admin);
  }

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.formLogin()
            .and()
            .authorizeHttpRequests().requestMatchers("/persons/by-city").permitAll()
            .and()
            .authorizeHttpRequests().requestMatchers("/persons/by-age-less-then").hasAuthority("USER")
            .and()
            .authorizeHttpRequests().anyRequest().authenticated();
    return http.build();
  }
}