/**
 * 
 */
package in.sachin.cricket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.sachin.cricket.entity.CFLTeam;
import in.sachin.cricket.repository.TeamRepository;
import in.sachin.cricket.util.CommonConstants;

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
		return teamRepository.findTopTeamPlayer();
	}

	public List<CFLTeam> fetchAllTeams() {
		return teamRepository.findAll();
	}
	
	public List<CFLTeam> fetchAllActiveTeams() {
		return teamRepository.findByTeamEnabled(1);
	}

	public void postTeam(CFLTeam team) {
		teamRepository.save(team);
	}

	public int getTeamStatus(String user) {
		int teamStatus = CommonConstants.TEAM_NOT_SELECTED;
		CFLTeam team = teamRepository.findByOwner(user);
		if (team != null) {
			teamStatus = CommonConstants.TEAM_SELECTED;
		}
		return teamStatus;
	}

	public CFLTeam getTeam(int id) {
		return teamRepository.findById(id);
	}
}
