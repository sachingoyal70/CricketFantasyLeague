/**
 * 
 */
package in.sachin.cricket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.sachin.cricket.entity.CFLMatches;

/**
 * @author sachingoyal
 *
 */
@Repository("cflMatchRepository")
public interface CFLMatchesRepository extends JpaRepository<CFLMatches, Integer> {

	List<CFLMatches> findByMatchDate(String matchDate);

	List<CFLMatches> findByMatchScoreDate(String matchDate);

}
