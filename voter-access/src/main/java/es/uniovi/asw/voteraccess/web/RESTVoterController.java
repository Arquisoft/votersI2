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

    @RequestMapping(value = {"/user.json", "/user"},
            method = RequestMethod.POST,
            consumes = {"application/json", "application/xml"},
            produces = {"application/json"})
    @Transactional(readOnly = true)
    public Voter getVoterInfoJSON(@RequestBody VoterRequestGet voterRequestGet) {
        return this.voterService.findByEmailAndPassword(voterRequestGet.getLogin(), voterRequestGet.getPassword());
    }

    @RequestMapping(value = "/user.xml",
            method = RequestMethod.POST,
            consumes = {"application/xml", "application/json"},
            produces = "application/xml")
    @Transactional(readOnly = true)
    public
    @ResponseBody
    Voter getVoterInfoXML(@RequestBody VoterRequestGet voterRequestGet) {
        return this.voterService.findByEmailAndPassword(voterRequestGet.getLogin(), voterRequestGet.getPassword());
    }

    @RequestMapping(value = {"/changepassword"},
            method = RequestMethod.POST,
            consumes = {"application/json", "application/xml"},
            produces = "application/json")
    @Transactional(readOnly = true)
    public void changePassword(@RequestBody VoterRequestChangePassword voterRequestChangePassword) {
        this.voterService.changePassword(voterRequestChangePassword.getLogin(), voterRequestChangePassword.getOldPassword(), voterRequestChangePassword.getNewPassword());
    }
}