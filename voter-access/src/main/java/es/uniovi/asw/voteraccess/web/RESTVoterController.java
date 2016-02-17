package es.uniovi.asw.voteraccess.web;

import es.uniovi.asw.voteraccess.model.Voter;
import es.uniovi.asw.voteraccess.service.voter.VoterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/rest")
@RestController
public class RESTVoterController {

    @Autowired
    private VoterService voterService;

    @RequestMapping(value = "/user",
                    method = RequestMethod.POST,
                    headers = "Accept=application/json",
                    produces = "application/json")
    @Transactional(readOnly = true)
    public Voter getVoterInfo(@RequestParam("login") String email,
                      @RequestParam("password") String password) {
        return this.voterService.findByEmailAndPassword(email, password);
    }

    @RequestMapping(value = "/changepassword",
                    method = RequestMethod.POST,
                    headers = "Accept=application/json",
                    produces = "application/json")
    @Transactional(readOnly = true)
    public boolean changePassword(@RequestParam("oldPassword") String oldPassword,
                                  @RequestParam("newPassword") String newPassword){
        return this.changePassword(oldPassword,newPassword);
    }
}