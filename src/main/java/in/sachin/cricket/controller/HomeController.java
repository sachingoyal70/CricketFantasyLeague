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
import org.springframework.web.bind.annotation.RequestParam;

import in.sachin.cricket.entity.CFLMessage;
import in.sachin.cricket.entity.CFLNoticeBoard;
import in.sachin.cricket.service.MessageService;
import in.sachin.cricket.service.NoticeBoardService;
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

	@Autowired
	MessageService messageService;

	@Autowired
	NoticeBoardService noticeBoardService;

	/**
	 * This method is used to display the WCFL home page.
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public String displayHomePage(Model model) {
		try {
			model.addAttribute("playerLeaderboard", playerService.fetchAllPlayers());
			model.addAttribute("teamLeaderboard", teamService.fetchAllTeams());
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
			// TODO - Logic for top teams
			model.addAttribute("playerLeaderboard", playerService.fetchAllPlayers());
			model.addAttribute("teamLeaderboard", teamService.fetchAllTeams());
		} catch (Exception e) {
			model.addAttribute("exp", "exp");
		}

		return "home";
	}

	@RequestMapping(value = "/home/howtoplay", method = RequestMethod.GET)
	public String displayHowToPlay(Model model) {
		return "howToPlay";
	}

	@RequestMapping(value = "/home/contactus", method = RequestMethod.GET)
	public String displayContactUs(Model model) {
		return "contactInfo";
	}

	@RequestMapping(value = "/home/getContactInfoDetails", params = { "name", "phone", "email",
			"message" }, method = RequestMethod.GET)
	public String displayContactUsdata(Model model, @RequestParam(value = "name") String name,
			@RequestParam(value = "phone") String phone, @RequestParam(value = "email") String email,
			@RequestParam(value = "message") String message) {

		CFLMessage dbMessage = new CFLMessage();
		dbMessage.setEmail(email);
		dbMessage.setMessage(message);
		dbMessage.setName(name);
		dbMessage.setPhone(phone);

		messageService.saveMsg(dbMessage);
		return "contactInfo";
	}

	@RequestMapping(value = "/home/timeline", method = RequestMethod.GET)
	public String displayTimeLine(Model model) {
		return "timeline";
	}

	@RequestMapping(value = "/home/prizes", method = RequestMethod.GET)
	public String displayPrizes(Model model) {
		return "prizes";
	}

	@RequestMapping(value = "/home/announcement", method = RequestMethod.GET)
	public String displayAnnouncement(Model model) {
		return "announcement";
	}

	@RequestMapping(value = "/home/testimonial", method = RequestMethod.GET)
	public String displayGallary(Model model) {
		return "testimonial";
	}

	@RequestMapping(value = "/home/noticeboard", method = RequestMethod.GET)
	public String displayNoticeBoard(Model model) {
		try {
			List<CFLNoticeBoard> noticeList = noticeBoardService.getAllNotices();
			if (noticeList != null && !noticeList.isEmpty()) {
				model.addAttribute("noticeList", noticeList);
			} else {
				model.addAttribute("exp", "exp");
			}
		} catch (Exception e) {
			model.addAttribute("exp", "exp");
		}
		return "noticeBoard";
	}

}
