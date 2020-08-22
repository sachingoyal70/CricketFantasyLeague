/**
 * 
 */
package in.sachin.cricket.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * @author sachingoyal
 *
 */

@Data
@Entity
@Table(name = "cfl_team_player")
public class CFLTeamPlayers {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "player_id")
	private int playerId;

	@Column(name = "team_player_name")
	private String name;

	@Column(name = "team_player_team")
	private String team;

	@Column(name = "team_player_role")
	private String role;

	@Column(name = "team_player_value", nullable = false)
	private int value;

	@Column(name = "team_player_run", nullable = false)
	private int run;

	@Column(name = "team_player_fours", nullable = false)
	private int fours;

	@Column(name = "team_player_sixes", nullable = false)
	private int sixes;

	@Column(name = "team_player_wicket", nullable = false)
	private int wicket;

	@Column(name = "team_player_score", nullable = false)
	private int score;

	@Column(name = "team_player_percentage")
	private String playerPercentage;

	@Column(name = "team_player_profile")
	private String playerProfile;

	@Column(name = "team_player_image")
	private String playerImage;

	@Column(name = "team_player_current_score", nullable = false)
	private int currentScore;
	
	@Column(name = "team_player_inactive", nullable = false)
	private int inactive;
	

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
	 * @return the playerId
	 */
	public int getPlayerId() {
		return playerId;
	}

	/**
	 * @param playerId the playerId to set
	 */
	public void setPlayerId(int playerId) {
		this.playerId = playerId;
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
	 * @return the team
	 */
	public String getTeam() {
		return team;
	}

	/**
	 * @param team the team to set
	 */
	public void setTeam(String team) {
		this.team = team;
	}

	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * @return the value
	 */
	public int getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(int value) {
		this.value = value;
	}

	/**
	 * @return the run
	 */
	public int getRun() {
		return run;
	}

	/**
	 * @param run the run to set
	 */
	public void setRun(int run) {
		this.run = run;
	}

	/**
	 * @return the fours
	 */
	public int getFours() {
		return fours;
	}

	/**
	 * @param fours the fours to set
	 */
	public void setFours(int fours) {
		this.fours = fours;
	}

	/**
	 * @return the sixes
	 */
	public int getSixes() {
		return sixes;
	}

	/**
	 * @param sixes the sixes to set
	 */
	public void setSixes(int sixes) {
		this.sixes = sixes;
	}

	/**
	 * @return the wicket
	 */
	public int getWicket() {
		return wicket;
	}

	/**
	 * @param wicket the wicket to set
	 */
	public void setWicket(int wicket) {
		this.wicket = wicket;
	}

	/**
	 * @return the score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * @param score the score to set
	 */
	public void setScore(int score) {
		this.score = score;
	}

	/**
	 * @return the playerPercentage
	 */
	public String getPlayerPercentage() {
		return playerPercentage;
	}

	/**
	 * @param playerPercentage the playerPercentage to set
	 */
	public void setPlayerPercentage(String playerPercentage) {
		this.playerPercentage = playerPercentage;
	}

	/**
	 * @return the playerProfile
	 */
	public String getPlayerProfile() {
		return playerProfile;
	}

	/**
	 * @param playerProfile the playerProfile to set
	 */
	public void setPlayerProfile(String playerProfile) {
		this.playerProfile = playerProfile;
	}

	/**
	 * @return the playerImage
	 */
	public String getPlayerImage() {
		return playerImage;
	}

	/**
	 * @param playerImage the playerImage to set
	 */
	public void setPlayerImage(String playerImage) {
		this.playerImage = playerImage;
	}

	/**
	 * @return the currentScore
	 */
	public int getCurrentScore() {
		return currentScore;
	}

	/**
	 * @param currentScore the currentScore to set
	 */
	public void setCurrentScore(int currentScore) {
		this.currentScore = currentScore;
	}

	/**
	 * @return the inactive
	 */
	public int getInactive() {
		return inactive;
	}

	/**
	 * @param inactive the inactive to set
	 */
	public void setInactive(int inactive) {
		this.inactive = inactive;
	}

}
