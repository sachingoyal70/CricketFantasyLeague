/**
 * 
 */
package in.sachin.cricket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;

import in.sachin.cricket.configurations.LoginRegisterMessages;
import in.sachin.cricket.configurations.MessageProperties;
import in.sachin.cricket.service.CFLMatchesService;
import in.sachin.cricket.service.EmailService;
import in.sachin.cricket.service.MessageService;
import in.sachin.cricket.service.NoticeBoardService;
import in.sachin.cricket.service.PlayerService;
import in.sachin.cricket.service.TeamService;
import in.sachin.cricket.service.UserService;

/**
 * @author sachingoyal
 *
 */

@Controller
public class MasterController {

	@Autowired
	protected TeamService teamService;

	@Autowired
	protected PlayerService playerService;

	@Autowired
	protected MessageService messageService;

	@Autowired
	protected NoticeBoardService noticeBoardService;

	@Autowired
	protected UserService userService;

	@Autowired
	protected LoginRegisterMessages loginregistermessageproperties;

	@Autowired
	protected EmailService emailservice;

	@Autowired
	protected MessageProperties messageproperties;

	@Autowired
	protected BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	protected CFLMatchesService matchService;
}
