/**
 * 
 */
package in.sachin.cricket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.sachin.cricket.entity.CFLPlayer;
import in.sachin.cricket.repository.PlayerRepository;

/**
 * @author sachingoyal
 *
 */

@Service("playerService")
public class PlayerService {

	private PlayerRepository playerRepository;

	@Autowired
	public PlayerService(PlayerRepository playerRepository) {
		this.playerRepository = playerRepository;
	}

	public List<CFLPlayer> fetchTopPlayers() {
		return playerRepository.findTopTeamPlayer();
	}

	public List<CFLPlayer> fetchAllPlayers() {
		return playerRepository.findAllTeamPlayer();
	}

	public List<CFLPlayer> getPlayerInfo(List<Integer> id) {
		return playerRepository.findAllTeamPlayer(id);
	}

	public void updatePlayers(List<CFLPlayer> cflPlayers) {
		playerRepository.saveAll(cflPlayers);
	}
}
