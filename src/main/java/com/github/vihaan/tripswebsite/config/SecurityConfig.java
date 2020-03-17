package com.github.vihaan.tripswebsite.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                //HTTP Basic authentication
                .httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/users").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/users/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/users").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/users/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.PATCH, "/users/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/trips").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/trips").hasRole("USER")
                .antMatchers(HttpMethod.PATCH, "/trips/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/destinations").hasRole("USER")
                .antMatchers(HttpMethod.GET, "/destinations/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/roles").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/roles/**").hasRole("USER")
                .and()
                .csrf().disable()
                .formLogin().disable();
    }
}
