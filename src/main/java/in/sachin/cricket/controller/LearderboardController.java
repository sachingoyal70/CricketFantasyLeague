/**
 * 
 */
package in.sachin.cricket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import in.sachin.cricket.entity.CFLPlayer;
import in.sachin.cricket.entity.CFLTeam;
import in.sachin.cricket.service.MessageService;
import in.sachin.cricket.service.NoticeBoardService;
import in.sachin.cricket.service.PlayerService;
import in.sachin.cricket.service.TeamService;

/**
 * @author sachingoyal
 *
 */

@Controller
public class LearderboardController {

	@Autowired
	TeamService teamService;

	@Autowired
	PlayerService playerService;

	@Autowired
	MessageService messageService;

	@Autowired
	NoticeBoardService noticeBoardService;

	@RequestMapping(value = "/home/leaderboard", method = RequestMethod.GET)
	public String displayLeaderBoard(Model model) {
		try {
			List<CFLTeam> teamLeaderboard = teamService.fetchAllTeams();
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

	@RequestMapping(value = "/home/previousleaderboard", method = RequestMethod.GET)
	public String displayPreviousLeaderBoard(Model model) {
		return "previousLeaderboard";
	}

}
