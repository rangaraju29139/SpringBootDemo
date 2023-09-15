package com.example.springboottodo;


import org.springframework.stereotype.Component;

@Component
public class AuthenticationService {
    public boolean authenticate(String username, String password){
        return (username.equals("rangaraju") && password.equals("rangaraju"));
    }
}
