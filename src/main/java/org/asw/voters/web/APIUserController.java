package org.asw.voters.web;

import org.asw.voters.domain.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class APIUserController {
    private static final String BASE_API_PATH = "/rest";

    @RequestMapping(value = BASE_API_PATH + "/user", method = RequestMethod.POST)
    public User show(@RequestParam("login") String email,
                     @RequestParam("password") String password) {
        return new User(email);
    }
}
