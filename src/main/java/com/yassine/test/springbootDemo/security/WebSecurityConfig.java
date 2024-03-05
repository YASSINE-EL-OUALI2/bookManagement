package com.yassine.test.springbootDemo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.yassine.test.springbootDemo.security.jwt.AuthEntryPointJwt;
import com.yassine.test.springbootDemo.security.jwt.AuthTokenFilter;
import com.yassine.test.springbootDemo.services.login.UserDetailsServiceImpl;

@Configuration
@EnableMethodSecurity
public class WebSecurityConfig {

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Autowired
    private AuthEntryPointJwt unauthorizeHandler;


    @Bean
    public AuthTokenFilter authenticationJwtTokenFilter() {
        return new AuthTokenFilter();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

        authProvider.setUserDetailsService(userDetailsService);
        ;
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
                .exceptionHandling(exception -> exception.authenticationEntryPoint(unauthorizeHandler))
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth ->
                              auth.requestMatchers("/api/auth/**").permitAll()
                                  .requestMatchers("/api/test/**").permitAll()
                                      .requestMatchers("/api/books/getall").permitAll()
                                      .requestMatchers("/api/books/getbyid").hasAnyRole("ADMIN","MODERATOR")
                                      .requestMatchers("/api/books/addbook").hasAnyRole("ADMIN","MODERATOR")
                                      .requestMatchers("/api/books/updatebook").hasAnyRole("ADMIN","MODERATOR")
                                      .requestMatchers("/api/books/deletebook").hasRole("ADMIN")
                                      .requestMatchers("/api/authors/getall").permitAll()
                                      .requestMatchers("/api/authors/getbyid").hasAnyRole("ADMIN","MODERATOR")
                                      .requestMatchers("/api/authors/addauthor").hasAnyRole("ADMIN","MODERATOR")
                                      .requestMatchers("/api/authors/updateauthor").hasAnyRole("ADMIN","MODERATOR")
                                      .requestMatchers("/api/authors/deleteauthor").hasRole("ADMIN")
                                      .requestMatchers("/api/categories/getall").permitAll()
                                      .requestMatchers("/api/categories/getbyid").hasAnyRole("ADMIN","MODERATOR")
                                      .requestMatchers("/api/categories/addcategory").hasAnyRole("ADMIN","MODERATOR")
                                      .requestMatchers("/api/categories/updatecategory").hasAnyRole("ADMIN","MODERATOR")
                                      .requestMatchers("/api/categories/deletecategory").hasRole("ADMIN")
                                      .requestMatchers("/api/inventory/getall").permitAll()
                                      .requestMatchers("/api/inventory/getitembyid").hasAnyRole("ADMIN","MODERATOR")
                                      .requestMatchers("/api/inventory/additem").hasAnyRole("ADMIN","MODERATOR")
                                      .requestMatchers("/api/inventory/updateinventory").hasAnyRole("ADMIN","MODERATOR")
                                      .requestMatchers("/api/inventory/deleteinventory").hasRole("ADMIN")
                                      .requestMatchers("/api/users/getall").hasRole("ADMIN")
                                      .requestMatchers("/api/users/addUser").hasRole("ADMIN")
                                      .requestMatchers("/api/users/updateUser").hasRole("ADMIN")
                                      .requestMatchers("/api/users/deleteUser").hasRole("ADMIN")
                                      .requestMatchers("/api/users/getUserbyid").hasRole("ADMIN")
                                      .anyRequest().authenticated()

                );
        http.authenticationProvider(authenticationProvider());
        http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }


}
