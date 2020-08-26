/**
 * 
 */
package in.sachin.cricket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.sachin.cricket.entity.CFLTeam;
import in.sachin.cricket.entity.CFLTeamPlayers;
import in.sachin.cricket.repository.TeamPlayerRepository;
import in.sachin.cricket.repository.TeamRepository;

/**
 * @author sachingoyal
 *
 */

@Service("teamService")
public class TeamService {

	private TeamRepository teamRepository;

	private TeamPlayerRepository teamPlayerRepository;

	@Autowired
	public TeamService(TeamRepository teamRepository, TeamPlayerRepository teamPlayerRepository) {
		this.teamRepository = teamRepository;
		this.teamPlayerRepository = teamPlayerRepository;
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

	public int teamCount() {
		return teamRepository.getTeamCount();
	}

	public int getTeamPlayer(int playerId) {
		return teamPlayerRepository.findByPlayerIdAndInactive(playerId, 0).size();
	}

	public List<CFLTeamPlayers> findAllTeamPlayer(List<Integer> ids) {
		return teamPlayerRepository.findAllTeamPlayer(ids);
	}

	public void updatePlayerList(List<CFLTeamPlayers> playerList) {
		teamPlayerRepository.saveAll(playerList);
	}

	public List<CFLTeam> getAllTeams() {
		return teamRepository.findAll();
	}

	public void updateTeamsScore(List<CFLTeam> teams) {
		teamRepository.saveAll(teams);
	}
}
