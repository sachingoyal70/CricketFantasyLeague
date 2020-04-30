/**
 * 
 */
package in.sachin.cricket.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import in.sachin.cricket.configurations.LoginRegisterMessages;
import in.sachin.cricket.configurations.MessageProperties;
import in.sachin.cricket.entity.User;
import in.sachin.cricket.service.EmailService;
import in.sachin.cricket.service.UserService;

/**
 * @author sachingoyal
 *
 */
@Controller
public class LoginController {

	@Autowired
	private UserService userService;

	@Autowired
	private LoginRegisterMessages loginregistermessageproperties;

	@Autowired
	private EmailService emailservice;

	@Autowired
	private MessageProperties messageproperties;

	/**
	 * This method is used to display the WCFL Registration page.
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = { "/home/registration" }, method = RequestMethod.GET)
	public String displayHomePage(Model model) {
		model.addAttribute("user", new User());
		return "registration";
	}

	@RequestMapping(value = "/home/registration", method = RequestMethod.POST)
	public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		User userExists = userService.findUserByEmail(user.getEmail());

		if (userExists != null) {
			bindingResult.rejectValue("email", "error.user",
					loginregistermessageproperties.getUserAlreadyExistsMessage());
		} else if (user.getPassword() != null && !user.getPassword().equals(user.getConfirmPassword())) {
			bindingResult.rejectValue("password", "error.user", loginregistermessageproperties.getPasswordNotMatch());

		} else if (user.getSerAnswer() != null && !user.getPassword().equals(user.getConfirmSerAnswer())) {
			bindingResult.rejectValue("serAnswer", "error.user",
					loginregistermessageproperties.getSecurityAnsNotMatch());
		}

		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("registration");
		} else {
			modelAndView.setViewName("login");
			modelAndView.addObject("message", loginregistermessageproperties.getActivationLinkSentMessage());
			userService.saveUser(user);
			emailservice.sendEmail(user, messageproperties.getEmailFrom(), messageproperties.getAcctactivationSubject(),
					messageproperties.getAcctactivationBody());
		}
		return modelAndView;
	}

}
