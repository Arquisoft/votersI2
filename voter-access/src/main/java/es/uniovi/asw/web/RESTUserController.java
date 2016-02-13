package es.uniovi.asw.web;

import es.uniovi.asw.domain.User;
import es.uniovi.asw.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/rest")
@RestController
public class RESTUserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user", method = RequestMethod.POST,
            produces = "application/json")
    @Transactional(readOnly = true)
    public User show(@RequestParam("login") String email,
                     @RequestParam("password") String password) {
        return this.userService.findByEmailAndPassword(email, password);
    }
}
