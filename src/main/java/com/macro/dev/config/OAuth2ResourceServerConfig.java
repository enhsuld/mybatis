package com.macro.dev.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.context.annotation.Profile;

@EnableResourceServer
@Configuration
@Profile("mvc")
public class OAuth2ResourceServerConfig extends ResourceServerConfigurerAdapter {
    @Override
    public void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
            .antMatchers("/employee").hasRole("ADMIN")
            .antMatchers("/","/home","/register","/login").permitAll()
            .antMatchers("/post").authenticated()
            .antMatchers("/post/postComment").authenticated()
            .antMatchers(HttpMethod.DELETE , "/post*//**").hasAuthority("ROLE_ADMIN");
    }

}
