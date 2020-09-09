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
@Table(name = "cfl_my_leaderboard")
public class CFLMyLeaderboard {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "email")
	private String email;

	@Column(name = "team_id")
	private int friendTeamid;

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
	 * @return the friendTeamid
	 */
	public int getFriendTeamid() {
		return friendTeamid;
	}

	/**
	 * @param friendTeamid the friendTeamid to set
	 */
	public void setFriendTeamid(int friendTeamid) {
		this.friendTeamid = friendTeamid;
	}

}
