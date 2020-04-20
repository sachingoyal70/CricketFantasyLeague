/**
 * 
 */
package in.sachin.cricket.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

/**
 * @author sachingoyal
 *
 */

@Data
@Entity
@Table(name = "cfl_team")
public class CFLTeam {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "team_user")
	private User user;

	@Column(name = "team_name")
	private String teamName;

	@Column(name = "team_players")
	private String teamPlayers;

	@Column(name = "team_enabled")
	private int teamEnabled;

	@Column(name = "team_score")
	private int teamScore;

	@Column(name = "team_current_score")
	private int teamCurrentScore;

	@Column(name = "team_modified")
	private int teamModified;

	@Column(name = "team_replaced_players")
	private String teamReplacedPlayers;

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
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the teamName
	 */
	public String getTeamName() {
		return teamName;
	}

	/**
	 * @param teamName the teamName to set
	 */
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	/**
	 * @return the teamPlayers
	 */
	public String getTeamPlayers() {
		return teamPlayers;
	}

	/**
	 * @param teamPlayers the teamPlayers to set
	 */
	public void setTeamPlayers(String teamPlayers) {
		this.teamPlayers = teamPlayers;
	}

	/**
	 * @return the teamEnabled
	 */
	public int getTeamEnabled() {
		return teamEnabled;
	}

	/**
	 * @param teamEnabled the teamEnabled to set
	 */
	public void setTeamEnabled(int teamEnabled) {
		this.teamEnabled = teamEnabled;
	}

	/**
	 * @return the teamScore
	 */
	public int getTeamScore() {
		return teamScore;
	}

	/**
	 * @param teamScore the teamScore to set
	 */
	public void setTeamScore(int teamScore) {
		this.teamScore = teamScore;
	}

	/**
	 * @return the teamCurrentScore
	 */
	public int getTeamCurrentScore() {
		return teamCurrentScore;
	}

	/**
	 * @param teamCurrentScore the teamCurrentScore to set
	 */
	public void setTeamCurrentScore(int teamCurrentScore) {
		this.teamCurrentScore = teamCurrentScore;
	}

	/**
	 * @return the teamModified
	 */
	public int getTeamModified() {
		return teamModified;
	}

	/**
	 * @param teamModified the teamModified to set
	 */
	public void setTeamModified(int teamModified) {
		this.teamModified = teamModified;
	}

	/**
	 * @return the teamReplacedPlayers
	 */
	public String getTeamReplacedPlayers() {
		return teamReplacedPlayers;
	}

	/**
	 * @param teamReplacedPlayers the teamReplacedPlayers to set
	 */
	public void setTeamReplacedPlayers(String teamReplacedPlayers) {
		this.teamReplacedPlayers = teamReplacedPlayers;
	}
	
	

}
