package es.uniovi.asw.webapp.web;

import es.uniovi.asw.webapp.model.UserChangePassword;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.uniovi.asw.voteraccess.model.Voter;
import es.uniovi.asw.voteraccess.service.exception.VoterNotFoundException;
import es.uniovi.asw.voteraccess.service.voter.VoterService;
import es.uniovi.asw.voteraccess.service.voter.impl.VoterServiceImpl;
import es.uniovi.asw.webapp.model.User;

@Controller
public class MainController {

	 private VoterService voterService = new VoterServiceImpl();
	
	/**
	 * Displays the home page of the voting system
	 * on path (/)
	 * @param model  Spring model 
	 * @return 		 The voting homepage
	 */
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String landing(Model model) {
		model.addAttribute("user", new User());
		return "login";
	}

	@RequestMapping(value="/changePassword", method=RequestMethod.GET)
	public String changePasswordGet(Model model) {

		model.addAttribute("userChangePassword", new UserChangePassword());
		return "changePassword";
	}


	/**
	 * Displays the voter view
	 * @param user   the user data
	 * @param model  Spring model
	 * @return       the voters view
	 */
	@RequestMapping(value="/user", method=RequestMethod.POST)
    public String login(@ModelAttribute User user, Model model) {
		// We have the user data in "user"
		// Now we check if it is in the DB
		Voter voter = null;
		try {
			voter = this.voterService.findByEmailAndPassword(user.getId(), user.getPassword());
		} catch (VoterNotFoundException e) {
			//If the user is not on DB, redirect to main
			model.addAttribute("error",true);
			return "redirect:/?error=notFound";
		}
		model.addAttribute("voter", voter);
    	return "main";
    }

	@RequestMapping(value="/changePassword", method=RequestMethod.POST)
	public String changePassword(@ModelAttribute UserChangePassword user, Model model) {

		try {
			//check correct data
			this.voterService.findByEmailAndPassword(user.getLogin(), user.getOldPassword());
			//change password
			this.voterService.changePassword(user.getLogin(), user.getOldPassword(), user.getNewPassword());

		} catch (VoterNotFoundException e) {

			//If the user is not on DB, redirect to main
			model.addAttribute("error",true);
			model.addAttribute("success", false);
			return "redirect:/changePassword?error=notFound";	//cambiar a la propia pagina con el mensaje de error
		}
		model.addAttribute("error",false);
		model.addAttribute("success", true);	//show success message
		return "redirect:/changePassword?success=true";		//cambiar a la propia pagina con el mensaje de exito
	}
}