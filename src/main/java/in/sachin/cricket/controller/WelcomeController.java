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

import in.sachin.cricket.entity.CFLPlayer;
import in.sachin.cricket.entity.CFLTeam;
import in.sachin.cricket.entity.CFLTeamPlayers;
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
		}

		CFLTeam.setTeamSelectedPlayers(cflTeamPlayers);
		CFLTeam.setOwner(email);
		CFLTeam.setUser(userService.findUserByEmail(email));
		CFLTeam.setSubstution(CommonConstants.TEAM_TOTAL_SUBSTITUTION);
		teamService.postTeam(CFLTeam);

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

}
