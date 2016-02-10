package org.asw.voters.web;


import org.asw.voters.domain.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @RequestMapping("/user")
    public User user() {
        return new User("pepe");
    }

    @RequestMapping("/")
    public String landing() {
        return "User Management Service";
    }
}