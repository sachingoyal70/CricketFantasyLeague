/**
 * 
 */
package in.sachin.cricket.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
/**
 * @author sachingoyal
 *
 */
@Controller
public class AdminController extends MasterController {
	
	/**
	 * This method is used to display the CFL admin welcome page.
	 * 
	 * @param model
	 * @return
	 */
	 @RequestMapping(value = "/admin", method = RequestMethod.GET)
	  public String displayAdminWelcome(Model model, Principal currentUser) {
	    if (currentUser != null) {
	      model.addAttribute("user", currentUser.getName());
	    }
	    return "welcomeAdmin";
	  }
}
