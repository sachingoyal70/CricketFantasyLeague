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
@Table(name = "cfl_matches")
public class CFLMatches {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "match_id")
	private int matchId;

	@Column(name = "match_date")
	private String matchDate;

	@Column(name = "match_score_date")
	private String matchScoreDate;

	@Column(name = "team_one")
	private String team1;

	@Column(name = "team_two")
	private String team2;

	@Column(name = "match_score")
	private String cricketScore;

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
	 * @return the matchId
	 */
	public int getMatchId() {
		return matchId;
	}

	/**
	 * @param matchId the matchId to set
	 */
	public void setMatchId(int matchId) {
		this.matchId = matchId;
	}

	/**
	 * @return the matchDate
	 */
	public String getMatchDate() {
		return matchDate;
	}

	/**
	 * @param matchDate the matchDate to set
	 */
	public void setMatchDate(String matchDate) {
		this.matchDate = matchDate;
	}

	/**
	 * @return the matchScoreDate
	 */
	public String getMatchScoreDate() {
		return matchScoreDate;
	}

	/**
	 * @param matchScoreDate the matchScoreDate to set
	 */
	public void setMatchScoreDate(String matchScoreDate) {
		this.matchScoreDate = matchScoreDate;
	}

	/**
	 * @return the team1
	 */
	public String getTeam1() {
		return team1;
	}

	/**
	 * @param team1 the team1 to set
	 */
	public void setTeam1(String team1) {
		this.team1 = team1;
	}

	/**
	 * @return the team2
	 */
	public String getTeam2() {
		return team2;
	}

	/**
	 * @param team2 the team2 to set
	 */
	public void setTeam2(String team2) {
		this.team2 = team2;
	}

	/**
	 * @return the cricketScore
	 */
	public String getCricketScore() {
		return cricketScore;
	}

	/**
	 * @param cricketScore the cricketScore to set
	 */
	public void setCricketScore(String cricketScore) {
		this.cricketScore = cricketScore;
	}

}
