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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import in.sachin.cricket.entity.CFLMyLeaderboard;
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
	// public String displayPreviousLeaderBoard(Model mod"el) {
	// return "previousLeaderboard";
//	}

	@RequestMapping(value = { "/home/teamDetails/{id}" })
	public String showTeamDetails(@PathVariable("id") int id, Model model) {
		CFLTeam teamDetails = teamService.getTeam(id);
		model.addAttribute("teamDetails", teamDetails);
		return "teamDetails";

	}

	@RequestMapping(value = "/welcome/myleaderboard", method = RequestMethod.GET)
	public String myLeaderBoard(Model model, HttpServletRequest request) {
		String email = request.getUserPrincipal().getName();
		List<CFLTeam> teams = teamService.fetchAllActiveTeams();
		model.addAttribute("teams", teams);
		CFLMyLeaderboard team = new CFLMyLeaderboard();
		team.setEmail(email);
		model.addAttribute("myLeaderboard", team);

		List<CFLMyLeaderboard> myTeams = teamService.getLederboardTeam(email);

		List<CFLTeam> myLeaderboardTeams = new ArrayList<CFLTeam>();

		if (myTeams != null && !myTeams.isEmpty()) {

			List<Integer> abc = new ArrayList<Integer>();

			for (CFLMyLeaderboard t : myTeams) {
				abc.add(t.getFriendTeamid());
			}

			myLeaderboardTeams = teamService.getMyLeaderboardTeams(abc);
		}

		model.addAttribute("teamLeaderboard",
				myLeaderboardTeams == null ? new ArrayList<CFLTeam>() : myLeaderboardTeams);

		return "myleaderboard";
	}

	@RequestMapping(value = "/welcome/myleaderboard", method = RequestMethod.POST)
	public ModelAndView myLeaderBoardUpdate(@Valid CFLMyLeaderboard team, BindingResult bindingResult,
			HttpServletRequest request, Model model) {
		String email = request.getUserPrincipal().getName();
		
		if (team != null && team.getFriendTeamid() != 0) {
			team.setEmail(email);
			teamService.updateMyLeaderboard(team);
		}

		ModelAndView view = new ModelAndView();

		view.setViewName("redirect:/welcome/myleaderboard");


		return view;

	}

}
