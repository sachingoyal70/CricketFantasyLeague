/**
 * 
 */
package in.sachin.cricket.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import in.sachin.cricket.entity.CFLPlayer;
import in.sachin.cricket.entity.CFLTeam;
import in.sachin.cricket.entity.CFLTeamPlayers;

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
	public String displayWelcomePage(Model model, HttpServletRequest request) {
		String email = request.getUserPrincipal().getName();
		model.addAttribute("user", userService.getFirstName(email));
		return "welcome";
	}

	/**
	 * This method is used to display the WCFL welcome page.
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = { "/welcome/chooseteam" }, method = RequestMethod.GET)
	public String choseYourTeam(Model model, HttpServletRequest request) {
		CFLTeam teamData = new CFLTeam();
		model.addAttribute("playerList", playerService.fetchAllPlayers());
		model.addAttribute("teamData", teamData);
		return "selectTeam";
	}

	@RequestMapping(value = "/welcome/chooseteam", method = RequestMethod.POST)
	public String postTeam(@Valid CFLTeam CFLTeam, BindingResult bindingResult, HttpServletRequest request,
			Model model) {
		String teamPlayers = CFLTeam.getTeamPlayers();
		String[] teamPlayerList = teamPlayers.split(",");
		String email = request.getUserPrincipal().getName();

		List<CFLTeamPlayers> cflTeamPlayers = new ArrayList<CFLTeamPlayers>();

		for (int i = 0; i < teamPlayerList.length; i++) {
			CFLPlayer player = playerService.getPlayerInfo(teamPlayerList[i]);
			CFLTeamPlayers cflTeamPlayer = new CFLTeamPlayers();
			cflTeamPlayer.setPlayerId(player.getPlayerId());
			cflTeamPlayer.setName(player.getName());
			cflTeamPlayer.setTeam(player.getTeam());
			cflTeamPlayer.setRole(player.getRole());
			cflTeamPlayer.setValue(player.getValue());
			cflTeamPlayer.setPlayerPercentage(player.getPlayerPercentage());
			cflTeamPlayer.setPlayerImage(player.getPlayerImage());
			cflTeamPlayer.setPlayerProfile(player.getPlayerProfile());
			cflTeamPlayers.add(cflTeamPlayer);
		}

		CFLTeam.setTeamSelectedPlayers(cflTeamPlayers);
		CFLTeam.setOwner(email);
		CFLTeam.setUser(userService.findUserByEmail(email));
		teamService.postTeam(CFLTeam);

		model.addAttribute("user", userService.getFirstName(email));
		return "welcome";

	}

}
