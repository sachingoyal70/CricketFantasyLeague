/**
 * 
 */
package in.sachin.cricket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.sachin.cricket.entity.CFLTeam;
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
		return teamRepository.findAll();
	}

	public void postTeam(CFLTeam team) {
		teamRepository.save(team);
	}
}
