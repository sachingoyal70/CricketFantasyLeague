/**
 * 
 */
package in.sachin.cricket.schedular;

import java.util.List;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import in.sachin.cricket.controller.MasterController;
import in.sachin.cricket.entity.CFLPlayer;

/**
 * @author sachingoyal
 *
 */
@Component
public class UpdatePlayerPercentageSchedular extends MasterController {

	@Scheduled(fixedRate = 600000)
	public void scheduleTaskWithFixedRate() {
		List<CFLPlayer> players = playerService.fetchAllPlayers();
		int teamCount = teamService.teamCount();

		for (CFLPlayer player : players) {
			int playerCount = teamService.getTeamPlayer(player.getPlayerId());
			double percentage = 0;
			if (teamCount > 0) {
				percentage = (playerCount * 100) / teamCount;
			}
			player.setPlayerPercentage(String.valueOf(percentage) + '%');
		}

		playerService.updatePlayers(players);
	}

}
