package es.uniovi.asw.webapp.web;

import es.uniovi.asw.webapp.model.VoterDTO;
import es.uniovi.asw.webapp.service.exception.VoterNotFoundException;
import es.uniovi.asw.webapp.service.voter.VoterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

    @Autowired
    private VoterService voterService;

    /**
     * Displays the home page of the voting system
     * on path (/)
     *
     * @param model Spring model
     * @return The voting homepage
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String landing(Model model) {
        model.addAttribute("voter", new VoterDTO());
        return "voter/login";
    }

    /**
     * Displays the voter view
     *
     * @param voter  the user data
     * @param model Spring model
     * @return the voters view
     */
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String login(@ModelAttribute VoterDTO voter, Model model) {
        try {
            voter = this.voterService.find(voter);
            model.addAttribute("voter", voter);
            return "voter/main";
        } catch (VoterNotFoundException e) {
            model.addAttribute("error", true);
            model.addAttribute("voter", voter);
            return "voter/login";
        }
    }

    /**
     * Displays the change password view
     *
     * @param model Spring model
     * @return the change password view
     */
    @RequestMapping(value = "/changePassword", method = RequestMethod.GET)
    public String changePasswordGet(Model model) {
        model.addAttribute("voter", new VoterDTO());
        return "voter/changePassword";
    }

    /**
     * Displays the change password view with a success or error message
     *
     * @param model Spring model
     * @return the change password view
     */
    @RequestMapping(value = "/changePassword", method = RequestMethod.POST)
    public String changePassword(@ModelAttribute VoterDTO voter, Model model) {
        model.addAttribute("voter", voter);
        try {
            this.voterService.changePassword(voter);
            model.addAttribute("success", true);
        } catch (VoterNotFoundException e) {
            model.addAttribute("error", true);
        }
        return "voter/changePassword";
    }

    @ExceptionHandler(VoterNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleVoterNotFoundException() {
        return "error/user_not_found";
    }
}