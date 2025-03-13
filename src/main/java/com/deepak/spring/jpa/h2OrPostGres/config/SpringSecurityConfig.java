package com.deepak.spring.jpa.h2OrPostGres.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
//@PropertySource("classpath:application.properties")
public class SpringSecurityConfig {
	   @Value("${spring.security.user.name}") 
	    private String userName;
	   @Value("${spring.security.user.password}") 
	    private String passWord;
    @Bean
    InMemoryUserDetailsManager userDetailsService(PasswordEncoder passwordEncoder) {
        UserDetails user = User.withUsername(userName)
            .password(passwordEncoder.encode(passWord))
           
            .build();

        UserDetails admin = User.withUsername("admin")
            .password(passwordEncoder.encode("admin"))
           
            .build();

        return new InMemoryUserDetailsManager(user, admin);
    }

    @SuppressWarnings("removal")
	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    	
        return http.authorizeHttpRequests(request -> request.requestMatchers("/api/").permitAll().anyRequest().authenticated() )
            .httpBasic(Customizer.withDefaults()).csrf().disable()
            .build();
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        return encoder;
    }
}