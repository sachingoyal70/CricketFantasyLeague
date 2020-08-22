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
		return teamRepository.findTopTeam();
	}

	public List<CFLTeam> fetchAllActiveTeams() {
		return teamRepository.findAllTeam();
	}

	public void postTeam(CFLTeam team) {
		teamRepository.save(team);
	}

	public CFLTeam getTeam(int id) {
		return teamRepository.findById(id);
	}

	public CFLTeam getTeam(String user) {
		return teamRepository.findByOwner(user);
	}
}
