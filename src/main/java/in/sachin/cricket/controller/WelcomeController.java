/**
 * 
 */
package in.sachin.cricket.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author sachingoyal
 *
 */

@Controller
public class WelcomeController extends MasterController {

	/**
	 * This method is used to display the WCFL welcome page.
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = { "/welcome" }, method = RequestMethod.GET)
	public String displayHomePage(Model model, HttpServletRequest request) {
		String email = request.getUserPrincipal().getName();
		model.addAttribute("user", userService.getFirstName(email));
		return "welcome";
	}

}
