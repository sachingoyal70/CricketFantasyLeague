/**
 * 
 */
package in.sachin.cricket.controller;

import java.io.IOException;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import in.sachin.cricket.entity.User;
import in.sachin.cricket.security.SecurityConstants;
import in.sachin.cricket.util.CommonUtils;

/**
 * @author sachingoyal
 *
 */
@Controller
public class LoginController extends MasterController {

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
		} else if (!bCryptPasswordEncoder.matches(user.getSerAnswer(), userExists.getSerAnswer())) {
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

	/**
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/home/signingerror", method = RequestMethod.GET)
	public String displaySigningInErrorPage(Model model) {
		model.addAttribute("user", new User());
		return "signingError";
	}

	/**
	 * @param registration
	 * @returo
	 */
	@RequestMapping(value = "/home/signingerror", method = RequestMethod.POST)
	public ModelAndView setSigningError(User user, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();

		User userExists = userService.findUserByEmail(user.getEmail());

		if (userExists == null) {
			modelAndView.setViewName("signingError");
			modelAndView.addObject("message", loginregistermessageproperties.getUserNotFoundMessage());
		} else if (user.getSigningError() == SecurityConstants.RESEND_ACTIVATION_LINK) {
			if(userExists.getActive()==0)
			{
			userExists.setUserActivationKey(CommonUtils.generateToken(user.getEmail()));
			userService.updateUser(userExists);
			modelAndView.addObject("message", loginregistermessageproperties.getActivationLinkSentMessage());
			modelAndView.setViewName("login");
			emailservice.sendEmail(userExists, messageproperties.getEmailFrom(), messageproperties.getAcctactivationSubject(),
					messageproperties.getAcctactivationBody());
			}
			else
			{
				userExists.setUserActivationKey(CommonUtils.generateToken(user.getEmail()));
				userService.updateUser(userExists);
				modelAndView.addObject("message", loginregistermessageproperties.getAccountAlreadyActive());
				modelAndView.setViewName("login");
				emailservice.sendEmail(userExists, messageproperties.getEmailFrom(), messageproperties.getAcctactivationSubject(),
						messageproperties.getAcctactivationBody());
			}
		} else {
			String newPassword = CommonUtils.generateCommonTextPassword();
			modelAndView.addObject("message", loginregistermessageproperties.getNewPasswordSentMessage());
			userExists.setPassword(bCryptPasswordEncoder.encode(newPassword));
			userService.updateUser(userExists);
			modelAndView.setViewName("login");
			emailservice.forgetPassword(userExists, messageproperties.getEmailFrom(),
					messageproperties.getForgetPasswordSubject(), messageproperties.getForgetPasswordBody(),
					newPassword);
		}
		return modelAndView;

	}

	@RequestMapping(value = { "/home/accountactivation/{email}/{token}" })
	public ModelAndView view(@PathVariable("email") String email, @PathVariable("token") String token)
			throws IOException {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		User userExists = userService.findUserByEmail(email);
		if (userExists == null) {
			modelAndView.addObject("message", loginregistermessageproperties.getUserNotFoundMessage());
		} else {
			boolean isValidToken = CommonUtils.isValidToken(token, userExists.getUserActivationKey());
			if (isValidToken) {
				userExists.setActive(1);
				userService.updateUser(userExists);
				modelAndView.addObject("message", loginregistermessageproperties.getSuccessAcctActivationMessage());
			} else {
				modelAndView.addObject("message", loginregistermessageproperties.getFailedAcctActivationMessage());
			}
		}
		return modelAndView;
	}

}
