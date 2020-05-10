/**
 * 
 */
package in.sachin.cricket.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

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

		} else if (user.getSerAnswer() != null && !user.getSerAnswer().equals(user.getConfirmSerAnswer())) {
			bindingResult.rejectValue("serAnswer", "error.user",
					loginregistermessageproperties.getSecurityAnsNotMatch());
		}

		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("registration");
		} else {
			modelAndView.setViewName("login");
			modelAndView.addObject("message", loginregistermessageproperties.getRegistrationSuccessMessage());
			userService.saveUser(user);
			emailservice.sendEmail(user, messageproperties.getEmailFrom(), messageproperties.getAcctactivationSubject(),
					messageproperties.getAcctactivationBody());
		}
		return modelAndView;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView setupform(ModelMap model, @RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		if (error != null) {
			modelAndView.addObject("message", loginregistermessageproperties.getInCorrectLoginMessage());
		}

		if (logout != null) {
			modelAndView.addObject("message", loginregistermessageproperties.getLogoutSuccessMessage());
		}

		return modelAndView;
	}

	/**
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/home/forgotpassword", method = RequestMethod.GET)
	public String displayForgetPasswordPage(Model model) {
		model.addAttribute("user", new User());
		return "forgotPassword";
	}

	/**
	 * @param registration
	 * @returo
	 */
	@RequestMapping(value = "/home/forgotpassword", method = RequestMethod.POST)
	public ModelAndView setForgetPassword(User user, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();

		User userExists = userService.findUserByEmail(user.getEmail());

		if (userExists == null) {
			modelAndView.setViewName("forgotPassword");
			modelAndView.addObject("message", loginregistermessageproperties.getUserNotFoundMessage());
		} else {
			user.setSerQuestion(userExists.getSerQuestion());
			modelAndView.addObject("user", user);
			modelAndView.setViewName("resetPassword");
		}
		return modelAndView;

	}

	/**
	 * @param registration
	 * @returo
	 */
	@RequestMapping(value = "/home/resetpassword", method = RequestMethod.POST)
	public ModelAndView resetPassword(User user, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();

		User userExists = userService.findUserByEmail(user.getEmail());

		if (userExists == null) {
			modelAndView.setViewName("forgotPassword");
			modelAndView.addObject("message", loginregistermessageproperties.getUserNotFoundMessage());
		} else if (!userExists.getSerAnswer().equals(user.getSerAnswer())) {
			modelAndView.addObject("message", loginregistermessageproperties.getIncorrectSecAnswer());
			modelAndView.addObject("user", user);
			modelAndView.setViewName("resetPassword");
		} else if (user.getPassword() != null && !user.getPassword().equals(user.getConfirmPassword())) {
			modelAndView.addObject("message", loginregistermessageproperties.getPasswordNotMatch());
			modelAndView.addObject("user", user);
			modelAndView.setViewName("resetPassword");
		} else {
			userExists.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
			userService.updateUser(userExists);
			modelAndView.addObject("message", loginregistermessageproperties.getPasswordResetSuccess());
			modelAndView.setViewName("login");

		}
		return modelAndView;

	}

}
