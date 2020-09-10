/**
 * 
 */
package in.sachin.cricket.schedular;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import in.sachin.cricket.controller.MasterController;
import in.sachin.cricket.matchdata.modal.CFLMatches;
import in.sachin.cricket.matchdata.modal.Match;

/**
 * @author sachingoyal
 *
 */
@Component
public class UpdateMatchDataSchedular extends MasterController {

	RestTemplate restTemplate = null;

	public RestTemplate getRestTemplate() {
		if (restTemplate == null) {
			restTemplate = new RestTemplate();
		}
		return restTemplate;
	}

	//@Scheduled(cron = "0 0/2 * * * ?", zone = "IST")
	public void updataMatchdata() throws ParseException {

		CFLMatches data = getRestTemplate()
				.getForObject("https://cricapi.com/api/matches?apikey=ttINSyqS9ZP4lxxtvozNgB6GhsP2", CFLMatches.class);

		if (data.getMatches() != null && data.getMatches().size() > 0) {

			List<in.sachin.cricket.entity.CFLMatches> matchList = new ArrayList<in.sachin.cricket.entity.CFLMatches>();

			for (Match m : data.getMatches()) {
				in.sachin.cricket.entity.CFLMatches cflMatch = new in.sachin.cricket.entity.CFLMatches();
				cflMatch.setTeam1(m.getTeam1());
				cflMatch.setTeam2(m.getTeam2());
				cflMatch.setMatchId(m.getUniqueId());
				cflMatch.setId(m.getUniqueId());
				cflMatch.setMatchDate(m.getDate().substring(0, 10));
				cflMatch.setMatchScoreDate(getNextDate(m.getDate().substring(0, 10)));
				matchList.add(cflMatch);
			}

			matchService.saveMatches(matchList);

		}
	}

	public static String getNextDate(String curDate) throws ParseException {
		final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		final Date date = format.parse(curDate);
		final Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_YEAR, 1);
		return format.format(calendar.getTime());
	}

}
