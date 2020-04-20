/**
 * 
 */
package in.sachin.cricket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import in.sachin.cricket.service.PlayerService;
import in.sachin.cricket.service.TeamService;

/**
 * @author sachingoyal
 *
 */

@Controller
public class HomeController {

	@Autowired
	TeamService teamService;

	@Autowired
	PlayerService playerService;

	/**
	 * This method is used to display the WCFL home page.
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public String displayHomePage(Model model) {
		try {
			model.addAttribute("playerLeaderboard", playerService.fetchTopTeams());
			model.addAttribute("teamLeaderboard", teamService.fetchTopTeams());
		} catch (Exception e) {
			model.addAttribute("exp", "exp");
		}

		return "home";
	}

	/**
	 * This method is used to display the WCFL home page.
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = { "/home" }, method = RequestMethod.GET)
	public String displayHomePageWithHomeUrl(Model model) {
		try {
			model.addAttribute("playerLeaderboard", playerService.fetchTopTeams());
			model.addAttribute("teamLeaderboard", teamService.fetchTopTeams());
		} catch (Exception e) {
			model.addAttribute("exp", "exp");
		}

		return "home";
	}
	
	
	@RequestMapping(value = "/home/howToPlay", method = RequestMethod.GET)
	  public String displayHowToPlay(Model model) {
	    return "howToPlay";
	  }

}
