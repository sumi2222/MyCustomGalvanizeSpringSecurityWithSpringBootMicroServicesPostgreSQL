package com.galvanize.gmdb.gmdb.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;


@Configuration
@EnableWebSecurity
public class CustomGmdbSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomGmdbSecurityEntryPoint authenticationEntryPoint;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication()
                .withUser("user").password(passwordEncoder().encode("moviepass"))
                .authorities("MOVIE")
                .and()
                .withUser("reviewer").password(passwordEncoder().encode("reviewer1pass"))
                .authorities("REVIEWER");

    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST,"/movie/**").authenticated()
                .antMatchers(HttpMethod.GET,"/movie/**").authenticated()
                .antMatchers(HttpMethod.PUT,"/movie/**").authenticated()
                .antMatchers(HttpMethod.DELETE,"/movie/**").authenticated()
                .antMatchers(HttpMethod.POST,"/review/**").authenticated()
                .antMatchers("/movie/createMovie").hasRole("MOVIE")
                .antMatchers(HttpMethod.POST,"/review/**").authenticated()
                .antMatchers("/review/createReview").hasRole("REVIEWER")
                .anyRequest().permitAll()
                .and()
                .httpBasic()
                .authenticationEntryPoint(authenticationEntryPoint)
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.addFilterAfter(new CustomSecurityFilter(), BasicAuthenticationFilter.class);

    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
