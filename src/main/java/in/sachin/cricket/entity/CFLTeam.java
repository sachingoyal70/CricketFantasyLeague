/**
 * 
 */
package in.sachin.cricket.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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

	@Column(name = "team_owner", nullable = false)
	private String owner;

	@Column(name = "team_name", nullable = false)
	private String teamName;

	@Transient
	private int[] teamPlayers;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "team_user")
	private User user;

	@Column(name = "team_enabled", nullable = false)
	private int teamEnabled;

	@Column(name = "team_score", nullable = false)
	private int teamScore;

	@Column(name = "team_current_score", nullable = false)
	private int teamCurrentScore;

	@Column(name = "team_modified", nullable = false)
	private int teamModified;

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "team_creation_date", nullable = false, updatable = false)
	private Date teamCreationDate;

	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "team_last_modified", nullable = false)
	private Date teamLastModified;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "team_players")
	private List<CFLTeamPlayers> teamSelectedPlayers;

	private int ranks;

	/**
	 * @return the ranks
	 */
	public int getRanks() {
		return ranks;
	}

	/**
	 * @param ranks the ranks to set
	 */
	public void setRanks(int ranks) {
		this.ranks = ranks;
	}

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
	 * @return the owner
	 */
	public String getOwner() {
		return owner;
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
	 * @param owner the owner to set
	 */
	public void setOwner(String owner) {
		this.owner = owner;
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
	public int[] getTeamPlayers() {
		return teamPlayers;
	}

	/**
	 * @param teamPlayers the teamPlayers to set
	 */
	public void setTeamPlayers(int[] teamPlayers) {
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
	 * @return the teamCreationDate
	 */
	public Date getTeamCreationDate() {
		return teamCreationDate;
	}

	/**
	 * @param teamCreationDate the teamCreationDate to set
	 */
	public void setTeamCreationDate(Date teamCreationDate) {
		this.teamCreationDate = teamCreationDate;
	}

	/**
	 * @return the teamLastModified
	 */
	public Date getTeamLastModified() {
		return teamLastModified;
	}

	/**
	 * @param teamLastModified the teamLastModified to set
	 */
	public void setTeamLastModified(Date teamLastModified) {
		this.teamLastModified = teamLastModified;
	}

	/**
	 * @return the teamSelectedPlayers
	 */
	public List<CFLTeamPlayers> getTeamSelectedPlayers() {
		return teamSelectedPlayers;
	}

	/**
	 * @param teamSelectedPlayers the teamSelectedPlayers to set
	 */
	public void setTeamSelectedPlayers(List<CFLTeamPlayers> teamSelectedPlayers) {
		this.teamSelectedPlayers = teamSelectedPlayers;
	}

}
