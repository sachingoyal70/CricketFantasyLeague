/**
 * 
 */
package in.sachin.cricket.service;

import java.util.ArrayList;
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
		return playerRepository.findAll();
	}

	public List<CFLPlayer> fetchAllPlayers() {

		CFLPlayer team = new CFLPlayer();
		team.setId(1);
		team.setFours(4);
		team.setRole("ALL");
		team.setScore(100);
		team.setPlayerPercentage("78%");
		team.setRun(40);

		List<CFLPlayer> c = new ArrayList<CFLPlayer>();
		c.add(team);
		return playerRepository.findAll();
	}

}
