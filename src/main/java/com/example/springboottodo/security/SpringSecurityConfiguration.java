package com.example.springboottodo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.function.Function;

@Configuration
public class SpringSecurityConfiguration {


    @Bean
    public InMemoryUserDetailsManager createUserDetailsManager(){


        UserDetails userDetails1 = createNewUser("rangaraju1", "rangaraju1");
        UserDetails userDetails2 = createNewUser("rangaraju2", "rangaraju2");

        return new InMemoryUserDetailsManager(userDetails1,userDetails2);

    }


    private UserDetails createNewUser(String userName, String password) {
        Function<String,String> passwordEncoder = (input) -> passwordEncoder().encode(input);
        UserDetails userDetails=User.builder().passwordEncoder(passwordEncoder).username(userName).password(password).roles("USER","ADMIN").build();
        return userDetails;
    }


    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
