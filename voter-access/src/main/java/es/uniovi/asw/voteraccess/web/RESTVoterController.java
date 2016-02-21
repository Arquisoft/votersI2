package es.uniovi.asw.voteraccess.web;

import es.uniovi.asw.voteraccess.model.Voter;
import es.uniovi.asw.voteraccess.model.VoterRequestChangePassword;
import es.uniovi.asw.voteraccess.model.VoterRequestGet;
import es.uniovi.asw.voteraccess.service.voter.VoterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/rest")
@RestController
public class RESTVoterController {

    @Autowired
    private VoterService voterService;

    /**
     * API rest method to return the data of a voter
     * @param voterRequestGet the data of the voter (login and password)
     * @return a 200 OK with the voter if successfully logged (else it throws an exception with error 404)
     */
    @RequestMapping(value = "/user",
            method = RequestMethod.POST,
            headers = "Accept=application/json",
            produces = "application/json")
    @Transactional(readOnly = true)
    public Voter getVoterInfo(@RequestBody VoterRequestGet voterRequestGet) {
        return this.voterService.findByEmailAndPassword(voterRequestGet.getLogin(), voterRequestGet.getPassword());
    }

    /**
     * API rest method to change the password of a voter
     * If changed successfully it returns a 200 OK else exception with a 404
     * @param voterRequestChangePassword the data of the voter (login, oldPassword and newPassword)
     */
    @RequestMapping(value = "/changepassword",
            method = RequestMethod.POST,
            headers = "Accept=application/json",
            produces = "application/json")
    @Transactional(readOnly = true)
    public void changePassword(@RequestBody VoterRequestChangePassword voterRequestChangePassword) {
        this.voterService.changePassword(voterRequestChangePassword.getLogin(), voterRequestChangePassword.getOldPassword(), voterRequestChangePassword.getNewPassword());
    }
}