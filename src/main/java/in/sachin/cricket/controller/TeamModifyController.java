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
public class TeamModifyController extends MasterController {

	/**
	 * This method is used to display the CFL home page.
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = { "/welcome/modifyteam" }, method = RequestMethod.GET)
	public String teamModify(Model model, HttpServletRequest request) {
		String email = request.getUserPrincipal().getName();
		CFLTeam team = teamService.getTeam(email);
		int teamStatus = CommonUtils.getTeamStatus(team);

		if (teamStatus == CommonConstants.TEAM_NOT_SELECTED || teamStatus == CommonConstants.TEAM_SELECTED) {
			model.addAttribute("teamStatus", CommonConstants.TEAM_NOT_SELECTED);
		} else if (team.getSubstution() <= 0) {
			model.addAttribute("teamStatus", CommonConstants.TEAM_NOT_SELECTED);
		} else {
			model.addAttribute("teamDetails", team);
			CFLTeam teamData = new CFLTeam();
			model.addAttribute("teamData", teamData);
			model.addAttribute("sub", team.getSubstution());
			model.addAttribute("teamStatus", CommonConstants.TEAM_APPROVED);
		}
		return "modifyTeam";
	}

	@RequestMapping(value = "/welcome/modifyteam", method = RequestMethod.POST)
	public ModelAndView postTeam(@Valid CFLTeam CFLTeam, BindingResult bindingResult, HttpServletRequest request,
			Model model) {
		String email = request.getUserPrincipal().getName();
		List<Integer> teamPlayers = CommonUtils.convertArrayToList(CFLTeam.getTeamPlayers());

		List<CFLPlayer> teamPlayerList = playerService.getPlayerInfo(teamPlayers);

		List<String> roles = new ArrayList<String>();

		int batsmen = 0;
		int bowler = 0;
		int allrounder = 0;
		int wicketkeeper = 0;
		int totalBudget = 0;
		int totalPlayers = 0;
		String oldPlayers = "";

		for (CFLPlayer player : teamPlayerList) {
			String role = player.getRole();
			roles.add(role);
			int playerValue = player.getValue();
			oldPlayers = player.getName() + ",";
			if ("BAT".equalsIgnoreCase(role)) {
				batsmen++;
				totalPlayers++;
				totalBudget = totalBudget + playerValue;
			} else if ("BWL".equalsIgnoreCase(role)) {
				bowler++;
				totalPlayers++;
				totalBudget = totalBudget + playerValue;
			} else if ("ALL".equalsIgnoreCase(role)) {
				allrounder++;
				totalPlayers++;
				totalBudget = totalBudget + playerValue;
			} else {
				wicketkeeper++;
				totalPlayers++;
				totalBudget = totalBudget + playerValue;
			}
		}

		CFLTeam team = teamService.getTeam(email);

		int totalTeamValue = CommonConstants.TOTAL_TEAM_BUDGET;
		for (CFLTeamPlayers player : team.getTeamSelectedPlayers()) {

			if (player.getInactive() == 0) {
				teamPlayers.add(player.getPlayerId());
				totalTeamValue = totalTeamValue - player.getValue();
			}
		}

		totalBudget = totalBudget + totalTeamValue;

		List<CFLPlayer> teamPlayerForModify = playerService.getPlayerInfo(teamPlayers, roles);

		model.addAttribute("batsmen", batsmen);
		model.addAttribute("bowler", bowler);
		model.addAttribute("allrounder", allrounder);
		model.addAttribute("wicketkeeper", wicketkeeper);
		model.addAttribute("totalBudget", totalBudget);
		model.addAttribute("totalPlayers", totalPlayers);
		model.addAttribute("teamData", CFLTeam);
		model.addAttribute("playerList", teamPlayerForModify);
		model.addAttribute("replacedPlayerName", oldPlayers);

		ModelAndView view = new ModelAndView();

		view.setViewName("selectNewPlayers");

		return view;

	}

	@RequestMapping(value = "/welcome/updateteam", method = RequestMethod.POST)
	public ModelAndView updateTeam(@Valid CFLTeam CFLTeam, BindingResult bindingResult, HttpServletRequest request,
			Model model) {
		String email = request.getUserPrincipal().getName();

		List<Integer> teamPlayers = CommonUtils.convertArrayToList(CFLTeam.getTeamPlayers());
		List<Integer> newTeamPlayers = CommonUtils.convertArrayToList(CFLTeam.getNewPlayers());

		CFLTeam team = teamService.getTeam(email);

		List<CFLTeamPlayers> teamPlayer = team.getTeamSelectedPlayers();

		for (CFLTeamPlayers oldTeamPlayers : teamPlayer) {
			if (teamPlayers.indexOf(oldTeamPlayers.getPlayerId()) != -1) {
				oldTeamPlayers.setInactive(1);
			}
		}

		for (CFLTeamPlayers newTeamPlay : teamPlayer) {
			if (newTeamPlayers.indexOf(newTeamPlay.getPlayerId()) != -1) {
				newTeamPlay.setInactive(0);
				newTeamPlayers.remove(newTeamPlayers.indexOf(newTeamPlay.getPlayerId()));
			}
		}

		if (newTeamPlayers != null && newTeamPlayers.size() > 0) {

			List<CFLPlayer> teamPlayerList = playerService.getPlayerInfo(newTeamPlayers);
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
				team.getTeamSelectedPlayers().add(cflTeamPlayer);
			}

		}

		if (!CommonUtils.validateDate()) {
			team.setSubstution(team.getSubstution() - teamPlayers.size());
		}

		teamService.postTeam(team);

		ModelAndView view = new ModelAndView();

		view.setViewName("redirect:/welcome");

		return view;

	}

}
