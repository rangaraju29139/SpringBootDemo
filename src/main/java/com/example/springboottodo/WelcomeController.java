package com.example.springboottodo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes("name")
public class WelcomeController {

    private String getLoggedinUsername(){
      Authentication authentication =  SecurityContextHolder.getContext().getAuthentication();
      return authentication.getName();
    }


    @RequestMapping("/")
    public String goToWelcomePage(ModelMap model)
    {
        model.put("name",getLoggedinUsername());
        return "welcome";
    }



}
