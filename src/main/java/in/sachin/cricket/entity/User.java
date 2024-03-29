/**
 * 
 */
package in.sachin.cricket.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

/**
 * @author sachingoyal
 *
 */

@Data
@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private int id;

	@Column(name = "email", unique = true, length = 100)
	@Email(message = "*Please provide a valid Email")
	@NotEmpty(message = "*Please provide an email")
	private String email;

	@Column(name = "password")
	@Length(min = 5, message = "*Your password must have at least 5 characters")
	@NotEmpty(message = "*Please provide your password")
	private String password;

	@Transient
	private String confirmPassword;

	@Column(name = "name")
	@NotEmpty(message = "*Please provide your name")
	private String name;

	@Column(name = "last_name")
	@NotEmpty(message = "*Please provide your last name")
	private String lastName;

	@Column(name = "phone_number")
	@NotEmpty(message = "*Please provide your phone number")
	private String phoneNumber;

	@Column(name = "user_location")
	@NotEmpty(message = "*Please provide your location")
	private String location;

	@Column(name = "user_ser_question")
	@NotEmpty(message = "*Please provide your security question")
	private String serQuestion;

	@Column(name = "user_ser_answer")
	@NotEmpty(message = "*Please provide your security answer")
	private String serAnswer;

	@Transient
	private String confirmSerAnswer;

	@Transient
	private int signingError;

	@Column(name = "user_activation_key")
	private String userActivationKey;

	@Column(name = "active")
	private int active;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @return the confirmPassword
	 */
	public String getConfirmPassword() {
		return confirmPassword;
	}

	/**
	 * @param confirmPassword the confirmPassword to set
	 */
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * @return the serQuestion
	 */
	public String getSerQuestion() {
		return serQuestion;
	}

	/**
	 * @param serQuestion the serQuestion to set
	 */
	public void setSerQuestion(String serQuestion) {
		this.serQuestion = serQuestion;
	}

	/**
	 * @return the serAnswer
	 */
	public String getSerAnswer() {
		return serAnswer;
	}

	/**
	 * @param serAnswer the serAnswer to set
	 */
	public void setSerAnswer(String serAnswer) {
		this.serAnswer = serAnswer;
	}

	/**
	 * @return the confirmSerAnswer
	 */
	public String getConfirmSerAnswer() {
		return confirmSerAnswer;
	}

	/**
	 * @param confirmSerAnswer the confirmSerAnswer to set
	 */
	public void setConfirmSerAnswer(String confirmSerAnswer) {
		this.confirmSerAnswer = confirmSerAnswer;
	}

	/**
	 * @return the userActivationKey
	 */
	public String getUserActivationKey() {
		return userActivationKey;
	}

	/**
	 * @param userActivationKey the userActivationKey to set
	 */
	public void setUserActivationKey(String userActivationKey) {
		this.userActivationKey = userActivationKey;
	}

	/**
	 * @return the active
	 */
	public int getActive() {
		return active;
	}

	/**
	 * @param active the active to set
	 */
	public void setActive(int active) {
		this.active = active;
	}

	/**
	 * @return the roles
	 */
	public Set<Role> getRoles() {
		return roles;
	}

	/**
	 * @param roles the roles to set
	 */
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	/**
	 * @return the signingError
	 */
	public int getSigningError() {
		return signingError;
	}

	/**
	 * @param signingError the signingError to set
	 */
	public void setSigningError(int signingError) {
		this.signingError = signingError;
	}

}
