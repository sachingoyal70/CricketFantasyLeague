/**
 * 
 */
package in.sachin.cricket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import in.sachin.cricket.entity.CFLTeam;

/**
 * @author sachingoyal
 *
 */

@Repository("teamRepository")
public interface TeamRepository extends JpaRepository<CFLTeam, Integer> {

	CFLTeam findByOwner(String ownerEmail);

	CFLTeam findById(int id);

	List<CFLTeam> findByTeamEnabled(int enabled);

	@Query(value = "SELECT * FROM cfl_team ORDER BY team_current_score DESC LIMIT 5", nativeQuery = true)
	List<CFLTeam> findTopTeamPlayer();

}
