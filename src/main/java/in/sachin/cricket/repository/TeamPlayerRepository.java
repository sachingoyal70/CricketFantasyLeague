/**
 * 
 */
package in.sachin.cricket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.sachin.cricket.entity.CFLTeamPlayers;

/**
 * @author sachingoyal
 *
 */
@Repository("teamPlayerRepository")
public interface TeamPlayerRepository extends JpaRepository<CFLTeamPlayers, Integer> {

	List<CFLTeamPlayers> findByPlayerIdAndInactive(int playerId, int inactive);
}
