package com.galvanize.gmdb.gmdb;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@Order(SecurityProperties.BASIC_AUTH_ORDER - 10)
public class AuthenticateGmdbApplication extends WebSecurityConfigurerAdapter {

    protected void Configure(HttpSecurity http) throws Exception {
        http.antMatcher("/**")
                .authorizeRequests()
                .mvcMatchers("movie/**").hasRole("auth-movie")
                .mvcMatchers("review/**").hasRole("auth-review")
                .mvcMatchers("reviewer/**").hasRole("auth-reviewer")
                .anyRequest().authenticated();
    }

}
