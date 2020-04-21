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

	// @RequestMapping(value = "/Playerleaderboard", method = RequestMethod.GET)
	// public String displayPlayerLeaderBoard(Model model) {
	// try {
	// List<WCFLPlayer> playerScore = wcflServices.getPlayersLeaderBoard();
	// WCFLPlayerLeadeboard playersDetails =
	// WCFLUtils.getPlayerLeaderboardDetails(playerScore);
	// model.addAttribute("playerLeaderboard", playerScore);
	// model.addAttribute("topBatsmen", playersDetails.getTopBatsmen());
//	      model.addAttribute("topBowler", playersDetails.getTopBowler());
//	      model.addAttribute("topAllRounder", playersDetails.getTopAllRounder());
//	      model.addAttribute("topWicketKeeper", playersDetails.getTopWicketKeeper());
//	    } catch (Exception e) {
//	      model.addAttribute("exp", "exp");
//	    }
//	    return "playerleaderboard";
//	  }
//
//	  @RequestMapping(value = "/Previousleaderboard", method = RequestMethod.GET)
//	  public String displayPreviousLeaderBoard(Model model) {
//	    return "previousleaderboard";
///	  }

	// @RequestMapping(value = "/teamDetails", params = { "id", "team" }, method =
	// RequestMethod.GET)
	// public String displayTeamDetails(Model model, @RequestParam(value = "id")
//	  String id, @RequestParam(value = "team")
///	  String team) {
	// model.addAttribute("teamDetails", wcflServices.getUserTeamDetails(id));
	// model.addAttribute("teamName", team);
	// return "teamDetails";
	// }
}
