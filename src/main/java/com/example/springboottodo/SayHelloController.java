package com.example.springboottodo;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class SayHelloController {

    @RequestMapping("/say-hello")
    @ResponseBody
    public String sayHello(){
        return "Hello";
    }

    @RequestMapping("/say-hello-html")
    @ResponseBody
    public String sayHelloHtml(){
        return """
                <html>
                <body><h1>This is the html page of sayHelloHtml</h1>
                </body>
                </html>
                
                """;
    }

    @RequestMapping("/say-hello-jsp")
    public String sayHelloJsp(){
        return "sayHello";
    }


}
