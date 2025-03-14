/**
 * 
 */
package in.sachin.cricket.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import in.sachin.cricket.entity.CFLTeam;
import in.sachin.cricket.entity.CFLTeamDetails;

/**
 * /**
 * 
 * @author sachingoyal
 *
 */
@Controller
public class AdminController extends MasterController {

	/**
	 * This method is used to display the CFL admin welcome page.
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String displayAdminWelcome(Model model, Principal currentUser) {
		if (currentUser != null) {
			model.addAttribute("user", currentUser.getName());
		}
		return "welcomeAdmin";
	}

	@RequestMapping(value = "/admin/activateteam", method = RequestMethod.GET)
	public String displayApproveTeam(Model model, Principal currentUser) {
		CFLTeamDetails teamData = new CFLTeamDetails();
		if (currentUser != null) {
			model.addAttribute("user", currentUser.getName());
		}
		model.addAttribute("teamList", teamService.getUnActivatedTeams());
		model.addAttribute("teamData", teamData);
		return "activateTeams";
	}

	@RequestMapping(value = "/admin/activateteam", method = RequestMethod.POST)
	public String postApproveTeams(@Valid CFLTeamDetails teamDetails, BindingResult bindingResult,
			HttpServletRequest request, Model model, Principal currentUser) {
		if (currentUser != null) {
			model.addAttribute("user", currentUser.getName());
		}

		if (teamDetails != null && teamDetails.getTeamDetails() != null) {
			for (int teamId : teamDetails.getTeamDetails()) {
				CFLTeam team = teamService.getTeam(teamId);
				team.setTeamEnabled(1);
				teamService.postTeam(team);

			}
		}

		ModelAndView view = new ModelAndView();

		view.setViewName("redirect:/admin/activateTeams");

		return "activateTeams";
	}

}
