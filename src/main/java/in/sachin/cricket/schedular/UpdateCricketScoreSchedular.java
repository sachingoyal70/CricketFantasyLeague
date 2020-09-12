/**
 * 
 */
package in.sachin.cricket.schedular;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import in.sachin.cricket.controller.MasterController;
import in.sachin.cricket.entity.CFLPlayer;
import in.sachin.cricket.entity.CFLTeam;
import in.sachin.cricket.entity.CFLTeamPlayers;
import in.sachin.cricket.scoreupdate.modal.Batting;
import in.sachin.cricket.scoreupdate.modal.Bowling;
import in.sachin.cricket.scoreupdate.modal.Data;
import in.sachin.cricket.scoreupdate.modal.Score_;
import in.sachin.cricket.scoreupdate.modal.Score__;
import in.sachin.cricket.scoreupdate.modal.WCFLMatchDataResponse;

/**
 * @author sachingoyal
 *
 */

@Component
public class UpdateCricketScoreSchedular extends MasterController {

	RestTemplate restTemplate = null;

	public RestTemplate getRestTemplate() {
		if (restTemplate == null) {
			restTemplate = new RestTemplate();
		}
		return restTemplate;
	}

	@Scheduled(cron = "0 07 06 * * ?", zone = "IST")
	public void updateMatchScoreData() {

		WCFLMatchDataResponse data = getRestTemplate().getForObject("http://localhost/home/test",
				WCFLMatchDataResponse.class);

		if (data != null && data.getData() != null) {
			updateScores(data);
		}
	}

	/**
	 * 
	 * @param matchdata
	 */
	public void updateScores(final WCFLMatchDataResponse matchdata) {
		final Map<Integer, int[]> scores = getScoresToUpdate(matchdata);

		List<Integer> playerIds = new ArrayList<Integer>(scores.keySet());

		List<CFLPlayer> players = playerService.getPlayerInfo(playerIds);
		List<CFLTeamPlayers> teamPlayers = teamService.findAllTeamPlayer(playerIds);

		for (CFLPlayer player : players) {

			if (scores.containsKey(player.getPlayerId())) {
				int[] scoreArray = scores.get(player.getPlayerId());
				int score = scoreArray[0] + scoreArray[1] + 2 * scoreArray[2] + 20 * scoreArray[3];
				int bonusPoints = scoreArray[0] / 50 * 20 + scoreArray[3] / 3 * 25 + scoreArray[5] * 20 + scoreArray[4];
				player.setScore(player.getScore() + score + bonusPoints);
				player.setTodayScore(0);
				player.setRun(player.getRun() + scoreArray[0]);
				player.setFours(player.getFours() + scoreArray[1]);
				player.setSixes(player.getSixes() + scoreArray[2]);
				player.setWicket(player.getWicket() + scoreArray[3]);
				player.setBonusScore(player.getBonusScore() + bonusPoints);

				player.setCurrentScore(player.getScore());
				player.setCurrentRun(player.getRun());
				player.setCurrentFours(player.getFours());
				player.setCurrentSixes(player.getSixes());
				player.setCurrentWicket(player.getWicket());
				player.setCurrentBonusScore(player.getBonusScore());

			}
		}
		playerService.updatePlayers(players);

		for (CFLTeamPlayers player : teamPlayers) {
			if (scores.containsKey(player.getPlayerId()) && player.getInactive() == 0) {
				int[] scoreArray = scores.get(player.getPlayerId());
				int score = scoreArray[0] + scoreArray[1] + 2 * scoreArray[2] + 20 * scoreArray[3];
				int bonusPoints = scoreArray[0] / 50 * 20 + scoreArray[3] / 3 * 25 + scoreArray[5] * 20 + scoreArray[4];
				player.setScore(player.getScore() + score + bonusPoints);
				player.setTodayScore(0);
				player.setRun(player.getRun() + scoreArray[0]);
				player.setFours(player.getFours() + scoreArray[1]);
				player.setSixes(player.getSixes() + scoreArray[2]);
				player.setWicket(player.getWicket() + scoreArray[3]);
				player.setBonusScore(player.getBonusScore() + bonusPoints);

				player.setCurrentScore(player.getScore());
				player.setCurrentRun(player.getRun());
				player.setCurrentFours(player.getFours());
				player.setCurrentSixes(player.getSixes());
				player.setCurrentWicket(player.getWicket());
				player.setCurrentBonusScore(player.getBonusScore());
			}
		}

		teamService.updatePlayerList(teamPlayers);

		List<CFLTeam> cflTeam = teamService.getAllTeams();

		for (CFLTeam team : cflTeam) {
			List<CFLTeamPlayers> player = team.getTeamSelectedPlayers();
			int score = 0;
			for (CFLTeamPlayers teamPlayer : player) {
				score = score + teamPlayer.getScore();
			}
			team.setTeamScore(score);
			team.setTeamCurrentScore(team.getTeamScore());
			team.setTeamTodayScore(0);
		}

		teamService.updateTeamsScore(cflTeam);

	}

	/**
	 * 
	 * @param matchdata
	 * @return
	 */
	public Map<Integer, int[]> getScoresToUpdate(final WCFLMatchDataResponse matchdata) {
		final Map<Integer, int[]> scoresMap = new HashMap<Integer, int[]>();
		int[] scoresData = null;
		final Data data = matchdata.getData();
		if (data != null) {
			final List<Batting> batting = data.getBatting();
			for (int i = 0; i < batting.size(); ++i) {
				final List<Score__> score = batting.get(i).getScores();
				for (int j = 0; j < score.size(); ++j) {
					scoresData = new int[6];
					final Score__ scoredata = score.get(j);
					scoresData[0] = getIntData(scoredata.getR());
					scoresData[1] = getIntData(scoredata.get4s());
					scoresData[2] = getIntData(scoredata.get6s());
					scoresMap.put(scoredata.getPid(), scoresData);
				}
			}
			final List<Bowling> bowling = data.getBowling();
			for (int k = 0; k < bowling.size(); ++k) {
				final List<Score_> score2 = bowling.get(k).getScores();
				for (int l = 0; l < score2.size(); ++l) {
					final Score_ scoredata2 = score2.get(l);
					if (scoresMap.containsKey(scoredata2.getPid())) {
						scoresData = scoresMap.get(scoredata2.getPid());
						scoresData[3] = getIntData(scoredata2.getW());
						scoresData[4] = scoredata2.get0s() == null ? 0 : scoredata2.get0s();
						scoresData[5] = getIntData(scoredata2.getM());
					} else {
						scoresData = new int[] { 0, 0, 0, getIntData(scoredata2.getW()),
								scoredata2.get0s() == null ? 0 : scoredata2.get0s(), getIntData(scoredata2.getM()) };
						scoresMap.put(scoredata2.getPid(), scoresData);
					}
				}
			}
		}
		return scoresMap;
	}

	/**
	 * 
	 * @param abc
	 * @return
	 */
	public static int getIntData(final String abc) {
		try {
			if (abc != null && abc.trim().isEmpty()) {
				return 0;
			}
			return Integer.parseInt(abc);
		} catch (Exception e) {
			return 0;
		}
	}

}
