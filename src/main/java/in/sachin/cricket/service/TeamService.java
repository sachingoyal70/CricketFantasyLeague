/**
 * 
 */
package in.sachin.cricket.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.sachin.cricket.entity.CFLTeam;
import in.sachin.cricket.entity.User;
import in.sachin.cricket.repository.TeamRepository;

/**
 * @author sachingoyal
 *
 */

@Service("teamService")
public class TeamService {

	private TeamRepository teamRepository;
	
	@Autowired
	public TeamService(TeamRepository teamRepository) {
		this.teamRepository = teamRepository;
	}

	public List<CFLTeam> fetchTopTeams() {
		return teamRepository.findAll();
	}
	
	public List<CFLTeam> fetchAllTeams() {
		User user = new User();
		user.setName("sachin");
		user.setLastName("goyal");
		user.setLastName("off");
		
		CFLTeam team = new CFLTeam();
		team.setUser(user);
		team.setId(1);
		team.setTeamCurrentScore(100);
		team.setTeamScore(100);
		team.setTeamName("anc");
	
		List<CFLTeam> c = new ArrayList<CFLTeam>();
		c.add(team);
		return c;
	}

}
