package es.uniovi.asw.voteraccess.web;

import es.uniovi.asw.voteraccess.model.Voter;
import es.uniovi.asw.voteraccess.model.VoterRequestChangePassword;
import es.uniovi.asw.voteraccess.model.VoterRequestGet;
import es.uniovi.asw.voteraccess.service.voter.VoterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/rest")
@RestController
public class RESTVoterController {

    @Autowired
    private VoterService voterService;

    /**
     * API rest method to return the data of a voter
     *
     * @param voterRequestGet the data of the voter (login and password)
     * @return a 200 OK with the voter if successfully logged (else it throws an exception with error 404)
     */
    @RequestMapping(value = {"/user.json", "/user"},
            method = RequestMethod.POST,
            consumes = {"application/json", "application/xml"},
            produces = {"application/json"})
    @Transactional(readOnly = true)
    public Voter getVoterInfoJSON(@RequestBody VoterRequestGet voterRequestGet) {
        return this.voterService.findByEmailAndPassword(voterRequestGet.getLogin(), voterRequestGet.getPassword());
    }

   /* TODO no es capaz a responder con xml
    @RequestMapping(value = "",
    @RequestMapping(value = "/user.xml",
            method = RequestMethod.POST,
            consumes = {"application/xml", "application/json"},
            produces = "application/xml")
    @Transactional(readOnly = true)
    public
    @ResponseBody
    Voter getVoterInfoXML(@RequestBody VoterRequestGet voterRequestGet) {
        return this.voterService.findByEmailAndPassword(voterRequestGet.getLogin(), voterRequestGet.getPassword());
    }*/

    /**
     * API rest method to change the password of a voter
     * If changed successfully it returns a 200 OK else exception with a 404
     *
     * @param voterRequestChangePassword the data of the voter (login, oldPassword and newPassword)
     */
    @RequestMapping(value = {"/changePassword"},
            method = RequestMethod.POST,
            consumes = {"application/json", "application/xml"},
            produces = "application/json")
    @Transactional(readOnly = true)
    public void changePassword(@RequestBody VoterRequestChangePassword voterRequestChangePassword) {
        this.voterService.changePassword(voterRequestChangePassword.getLogin(), voterRequestChangePassword.getOldPassword(), voterRequestChangePassword.getNewPassword());
    }

    @RequestMapping(value = {"/createVoter"},
            method = RequestMethod.POST,
            consumes = {"application/json", "application/xml"},
            produces = "application/json")
    @Transactional(readOnly = true)
    public Voter updateVoter(@RequestBody Voter voter) {
        return this.voterService.updateVoter(voter);
    }

}