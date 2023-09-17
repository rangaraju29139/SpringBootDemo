package com.example.springboottodo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes("name")
public class WelcomeController {

    @Autowired
    private AuthenticationService authenticationService;



    @RequestMapping("/")
    public String showHomePage(){
        return "home";
    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(){

        return "login";
    }
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String loginPost(@RequestParam String username, @RequestParam String password, ModelMap model){

        if(authenticationService.authenticate(username,password)){
            model.put("username", username);

            return "welcome";
        }
        model.put("errorMessage","Invalid Credentials Please try again");
        return "login";
    }

//    @RequestMapping(value = "**",method = {RequestMethod.GET,RequestMethod.POST})
//    public String showNotFoundPage(){
//        return "notFound";
//    }
}
