/**
 * 
 */
package in.sachin.cricket.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import in.sachin.cricket.entity.CFLPlayer;
import in.sachin.cricket.entity.CFLTeam;

/**
 * @author sachingoyal
 *
 */

@Controller
public class LeaderboardController extends MasterController {

	@RequestMapping(value = "/home/leaderboard", method = RequestMethod.GET)
	public String displayLeaderBoard(Model model) {
		try {
			List<CFLTeam> teamLeaderboard = teamService.fetchAllActiveTeams();
			model.addAttribute("teamLeaderboard", teamLeaderboard);
		} catch (Exception e) {
			model.addAttribute("exp", "exp");
		}
		return "leaderboard";
	}

	@RequestMapping(value = "/home/playerleaderboard", method = RequestMethod.GET)
	public String displayPlayerLeaderBoard(Model model) {
		try {
			List<CFLPlayer> playerLeaderboard = playerService.fetchAllPlayers();
			model.addAttribute("playerLeaderboard", playerLeaderboard);
		} catch (Exception e) {
			model.addAttribute("exp", "exp");
		}
		return "playerLeaderboard";
	}

	// @RequestMapping(value = "/home/previousleaderboard", method =
	// RequestMethod.GET)
	// public String displayPreviousLeaderBoard(Model model) {
	// return "previousLeaderboard";
//	}

	@RequestMapping(value = { "/home/teamDetails/{id}" })
	public String showTeamDetails(@PathVariable("id") int id, Model model) {
		CFLTeam teamDetails = teamService.getTeam(id);
		model.addAttribute("teamDetails", teamDetails);
		return "teamDetails";

	}

}
