package com.example.springboottodo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class LoginController {

    @Autowired
    private AuthenticationService authenticationService;


    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(){

        return "login";
    }
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String loginPost(@RequestParam String username, @RequestParam String password, ModelMap model){

        if(authenticationService.authenticate(username,password)){
            model.put("username", username);
            model.put("password", password);
            return "welcome";
        }
        return "login";


    }
}
