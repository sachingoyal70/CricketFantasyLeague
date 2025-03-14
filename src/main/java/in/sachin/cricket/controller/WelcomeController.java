/**
 * 
 */
package in.sachin.cricket.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Value;
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
import in.sachin.cricket.entity.CFLTeamPlayers;
import in.sachin.cricket.entity.User;
import in.sachin.cricket.util.CommonConstants;
import in.sachin.cricket.util.CommonUtils;

/**
 * @author sachingoyal
 *
 */

@Controller
public class WelcomeController extends MasterController {

	@Value("${key}")
	private String key;

	/**
	 * This method is used to display the CFL welcome page.
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = { "/welcome" }, method = RequestMethod.GET)
	public String displayWelcomePage(Model model, HttpServletRequest request) {
		String email = request.getUserPrincipal().getName();
		CFLTeam team = teamService.getTeam(email);
		int teamStatus = CommonUtils.getTeamStatus(team);
		model.addAttribute("user", userService.getFirstName(email));
		if (teamStatus == CommonConstants.TEAM_NOT_SELECTED) {
			model.addAttribute("teamStatus", CommonConstants.TEAM_NOT_SELECTED);
		} else if (teamStatus == CommonConstants.TEAM_SELECTED) {
			if (CommonUtils.validateDate()) {
				model.addAttribute("teamStatus", CommonConstants.TEAM_SELECTED);
			} else {
				model.addAttribute("teamStatus", CommonConstants.REGISTRATION_CLOSED);
			}
		} else {
			model.addAttribute("teamDetails", team);
			model.addAttribute("teamStatus", CommonConstants.TEAM_APPROVED);
		}
		return "welcome";
	}

	/**
	 * This method is used to display the CFL welcome page.
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = { "/welcome/changepwd" }, method = RequestMethod.GET)
	public String ChangePwd(Model model, HttpServletRequest request) {
		model.addAttribute("user", new User());
		model.addAttribute("success", 2);
		return "changePwd";
	}

	@RequestMapping(value = "/welcome/changepwd", method = RequestMethod.POST)
	public String udpdatePassword(@Valid User user, BindingResult bindingResult, HttpServletRequest request,
			Model model) {

		if (user.getPassword() == null || user.getPassword().trim().equals("")) {
			model.addAttribute("user", new User());
			model.addAttribute("success", 0);
			model.addAttribute("error", "Please enter the password");
		} else {
			if (!user.getPassword().trim().equals(user.getConfirmPassword())) {
				model.addAttribute("user", new User());
				model.addAttribute("success", 0);
				model.addAttribute("error", "password and confirm password did not match!");
			} else {
				String email = request.getUserPrincipal().getName();
				User usr = userService.findUserByEmail(email);
				usr.setPassword(user.getPassword());
				userService.updateUserPassword(usr);
				model.addAttribute("msg", "Password reset successfully!");
				model.addAttribute("success", 1);
			}
		}

		return "changePwd";

	}

	/**
	 * This method is used to display the CFL welcome page.
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = { "/welcome/oldplayers" }, method = RequestMethod.GET)
	public String displayOldPlayers(Model model, HttpServletRequest request) {
		String email = request.getUserPrincipal().getName();
		CFLTeam team = teamService.getTeam(email);
		int teamStatus = CommonUtils.getTeamStatus(team);

		if (teamStatus == CommonConstants.TEAM_NOT_SELECTED) {
			model.addAttribute("teamStatus", CommonConstants.TEAM_NOT_SELECTED);
		} else if (teamStatus == CommonConstants.TEAM_SELECTED) {
			model.addAttribute("teamStatus", CommonConstants.TEAM_SELECTED);
		} else {
			model.addAttribute("teamDetails", team);
			model.addAttribute("teamStatus", CommonConstants.TEAM_APPROVED);
		}
		return "substitutePlayers";
	}

	/**
	 * This method is used to display the CFL welcome page.
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = { "/welcome/chooseteam" }, method = RequestMethod.GET)
	public String choseYourTeam(Model model, HttpServletRequest request) {
		String email = request.getUserPrincipal().getName();

		int teamStatus = CommonUtils.getTeamStatus(teamService.getTeam(email));

		if (teamStatus == CommonConstants.TEAM_NOT_SELECTED) {
			CFLTeam teamData = new CFLTeam();
			model.addAttribute("playerList", playerService.fetchAllPlayers());
			model.addAttribute("teamData", teamData);
			model.addAttribute("teamStatus", CommonConstants.TEAM_NOT_SELECTED);
		} else {
			model.addAttribute("teamStatus", CommonConstants.TEAM_SELECTED);
		}

		return "selectTeam";
	}

	@RequestMapping(value = "/welcome/chooseteam", method = RequestMethod.POST)
	public ModelAndView postTeam(@Valid CFLTeam CFLTeam, BindingResult bindingResult, HttpServletRequest request,
			Model model) {
		List<Integer> teamPlayers = CommonUtils.convertArrayToList(CFLTeam.getTeamPlayers());

		List<CFLPlayer> teamPlayerList = playerService.getPlayerInfo(teamPlayers);
		String email = request.getUserPrincipal().getName();

		List<CFLTeamPlayers> cflTeamPlayers = new ArrayList<CFLTeamPlayers>();

		int totalValue = 0;
		for (int i = 0; i < teamPlayerList.size(); i++) {
			CFLPlayer player = teamPlayerList.get(i);
			CFLTeamPlayers cflTeamPlayer = new CFLTeamPlayers();
			cflTeamPlayer.setPlayerId(player.getPlayerId());
			cflTeamPlayer.setName(player.getName());
			cflTeamPlayer.setTeam(player.getTeam());
			cflTeamPlayer.setRole(player.getRole());
			cflTeamPlayer.setValue(player.getValue());
			cflTeamPlayer.setPlayerImage(player.getPlayerImage());
			cflTeamPlayer.setPlayerProfile(player.getPlayerProfile());
			cflTeamPlayers.add(cflTeamPlayer);
			totalValue = totalValue + player.getValue();
		}

		if (totalValue <= CommonConstants.TOTAL_TEAM_BUDGET) {
			CFLTeam.setTeamSelectedPlayers(cflTeamPlayers);
			CFLTeam.setOwner(email);
			CFLTeam.setUser(userService.findUserByEmail(email));
			CFLTeam.setSubstution(CommonConstants.TEAM_TOTAL_SUBSTITUTION);
			teamService.postTeam(CFLTeam);
		}

		ModelAndView view = new ModelAndView();

		view.setViewName("redirect:/welcome");

		return view;

	}

	/**
	 * This method is used to display the CFL welcome page.
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = { "/welcome/activateteam/{ourKey}" }, method = RequestMethod.GET)
	public ModelAndView activateTeam(@PathVariable("ourKey") String ourKey, Model model, HttpServletRequest request) {
		String email = request.getUserPrincipal().getName();

		CFLTeam team = teamService.getTeam(email);
		int teamStatus = CommonUtils.getTeamStatus(team);

		if (teamStatus == CommonConstants.TEAM_SELECTED && key.equals(ourKey)) {
			team.setTeamEnabled(1);
			teamService.postTeam(team);
			emailservice.teamActivation(email, messageproperties.getEmailFrom(),
					messageproperties.getActiveTeamSubject(), messageproperties.getActiveTeamBody());

		}

		ModelAndView view = new ModelAndView();

		view.setViewName("redirect:/welcome");

		return view;
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

	@RequestMapping(value = { "/welcome/deleteteam/{id}" })
	public ModelAndView showTeamDetails(@PathVariable("id") int id, Model modelm, HttpServletRequest request) {
		String email = request.getUserPrincipal().getName();
		List<CFLMyLeaderboard> myTeams = teamService.getLederboardTeam(email);
		ModelAndView view = new ModelAndView();
		if (myTeams != null && !myTeams.isEmpty()) {
			for (CFLMyLeaderboard t : myTeams) {
				if (t.getFriendTeamid() == id) {
					teamService.deleteMyLeaderBoardTeam(t);
				}
			}

		}

		view.setViewName("redirect:/welcome/myleaderboard");
		return view;

	}

	@RequestMapping(value = "/welcome/playerleaderboard", method = RequestMethod.GET)
	public String displayPlayerLeaderBoard(Model model) {
		try {
			List<CFLPlayer> playerLeaderboard = playerService.fetchAllPlayers();
			model.addAttribute("playerLeaderboard", playerLeaderboard);
		} catch (Exception e) {
			model.addAttribute("exp", "exp");
		}
		return "welcomePlayerleaderboard";
	}

	@RequestMapping(value = "/welcome/teamleaderboard", method = RequestMethod.GET)
	public String displayLeaderBoard(Model model) {
		try {
			List<CFLTeam> teamLeaderboard = teamService.fetchAllActiveTeams();
			model.addAttribute("teamLeaderboard", teamLeaderboard);
		} catch (Exception e) {
			model.addAttribute("exp", "exp");
		}
		return "welcomeleaderboard";
	}

}
