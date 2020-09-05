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

	@Scheduled(cron = "0 0/15 * * * ?", zone = "IST")
	public void updatePlayerPercentage() {

		emailservice.testJob("sachingoyal70@gmail.com", messageproperties.getEmailFrom(),
				"Run updatePlayerPercentage()", "Run updatePlayerPercentage()");

		List<CFLPlayer> players = playerService.fetchAllPlayers();
		int teamCount = teamService.teamCount();

		for (CFLPlayer player : players) {
			int playerCount = teamService.getTeamPlayer(player.getPlayerId());
			double percentage = 0;
			if (teamCount > 0) {
				percentage = (playerCount * 100) / teamCount;
				percentage = (double) Math.round(percentage * 100) / 100;
			}
			player.setPlayerPercentage(String.valueOf(percentage) + '%');
		}

		playerService.updatePlayers(players);
	}

}
