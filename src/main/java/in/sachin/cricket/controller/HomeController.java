/**
 * 
 */
package in.sachin.cricket.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author sachingoyal
 *
 */

@Controller
public class HomeController {

	
	/**
	   * This method is used to display the WCFL home page.
	   * 
	   * @param model
	   * @return
	   */
	  @RequestMapping(value = { "/"}, method = RequestMethod.GET)
	  public String displayHomePage(Model model) {
	    try {
	      model.addAttribute("playerLeaderboard", new ArrayList<String>());
	      model.addAttribute("teamLeaderboard",  new ArrayList<String>());
	    } catch (Exception e) {
	      model.addAttribute("exp", "exp");
	    }
	    
	    return "home";
	  }

	

}
