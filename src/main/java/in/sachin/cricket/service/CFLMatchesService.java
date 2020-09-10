/**
 * 
 */
package in.sachin.cricket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.sachin.cricket.entity.CFLMatches;
import in.sachin.cricket.repository.CFLMatchesRepository;

/**
 * @author sachingoyal
 *
 */

@Service("cflmatchservice")
public class CFLMatchesService {

	private CFLMatchesRepository cflMatchRepository;

	@Autowired
	public CFLMatchesService(CFLMatchesRepository cflMatchRepository) {
		this.cflMatchRepository = cflMatchRepository;
	}

	public void saveMatches(List<CFLMatches> matches) {
		cflMatchRepository.saveAll(matches);
	}

	public List<CFLMatches> getLiveMatches(String date) {
		return cflMatchRepository.findByMatchDate(date);
	}

	public List<CFLMatches> getPreviousMatches(String date) {
		return cflMatchRepository.findByMatchScoreDate(date);
	}

}
