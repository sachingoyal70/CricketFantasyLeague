package in.sachin.cricket.configurations;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@PropertySource("classpath:messages.properties")
@Component
@ConfigurationProperties("email")
public class MessageProperties {
	
	private String emailFrom;
	private String AcctactivationSubject;
	private String AcctactivationBody;
	private String forgetPasswordSubject;
	private String forgetPasswordBody;
	private String activeTeamSubject;
	private String activeTeamBody;
	/**
	 * @return the emailFrom
	 */
	public String getEmailFrom() {
		return emailFrom;
	}
	/**
	 * @param emailFrom the emailFrom to set
	 */
	public void setEmailFrom(String emailFrom) {
		this.emailFrom = emailFrom;
	}
	/**
	 * @return the acctactivationSubject
	 */
	public String getAcctactivationSubject() {
		return AcctactivationSubject;
	}
	/**
	 * @param acctactivationSubject the acctactivationSubject to set
	 */
	public void setAcctactivationSubject(String acctactivationSubject) {
		AcctactivationSubject = acctactivationSubject;
	}
	/**
	 * @return the acctactivationBody
	 */
	public String getAcctactivationBody() {
		return AcctactivationBody;
	}
	/**
	 * @param acctactivationBody the acctactivationBody to set
	 */
	public void setAcctactivationBody(String acctactivationBody) {
		AcctactivationBody = acctactivationBody;
	}
	/**
	 * @return the forgetPasswordSubject
	 */
	public String getForgetPasswordSubject() {
		return forgetPasswordSubject;
	}
	/**
	 * @param forgetPasswordSubject the forgetPasswordSubject to set
	 */
	public void setForgetPasswordSubject(String forgetPasswordSubject) {
		this.forgetPasswordSubject = forgetPasswordSubject;
	}
	/**
	 * @return the forgetPasswordBody
	 */
	public String getForgetPasswordBody() {
		return forgetPasswordBody;
	}
	/**
	 * @param forgetPasswordBody the forgetPasswordBody to set
	 */
	public void setForgetPasswordBody(String forgetPasswordBody) {
		this.forgetPasswordBody = forgetPasswordBody;
	}
	/**
	 * @return the activeTeamSubject
	 */
	public String getActiveTeamSubject() {
		return activeTeamSubject;
	}
	/**
	 * @param activeTeamSubject the activeTeamSubject to set
	 */
	public void setActiveTeamSubject(String activeTeamSubject) {
		this.activeTeamSubject = activeTeamSubject;
	}
	/**
	 * @return the activeTeamBody
	 */
	public String getActiveTeamBody() {
		return activeTeamBody;
	}
	/**
	 * @param activeTeamBody the activeTeamBody to set
	 */
	public void setActiveTeamBody(String activeTeamBody) {
		this.activeTeamBody = activeTeamBody;
	}

}
