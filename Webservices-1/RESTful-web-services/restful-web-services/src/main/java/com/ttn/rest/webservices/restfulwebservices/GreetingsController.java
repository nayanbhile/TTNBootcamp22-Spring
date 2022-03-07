// Create a simple REST ful service in Spring Boot which returns the Response "Welcome to spring boot".

package com.ttn.rest.webservices.restfulwebservices;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingsController {

    @GetMapping(path = "/greetMessage")
    public String Greet()
    {
        return "Welcome to spring boot";
    }
}
