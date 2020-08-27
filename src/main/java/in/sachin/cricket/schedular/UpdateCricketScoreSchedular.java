/**
 * 
 */
package in.sachin.cricket.schedular;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import in.sachin.cricket.controller.MasterController;

/**
 * @author sachingoyal
 *
 */

@Component
public class UpdateCricketScoreSchedular extends MasterController {
	
	@Scheduled(cron = "0 00 06 * * ?")
	public void updateMatchScoreData() {
		System.out.println("updateMatchScoreData()");
	}

}
