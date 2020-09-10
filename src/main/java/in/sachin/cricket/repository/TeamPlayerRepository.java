/**
 * 
 */
package in.sachin.cricket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import in.sachin.cricket.entity.CFLTeamPlayers;

/**
 * @author sachingoyal
 *
 */
@Repository("teamPlayerRepository")
public interface TeamPlayerRepository extends JpaRepository<CFLTeamPlayers, Integer> {

	List<CFLTeamPlayers> findByPlayerIdAndInactive(int playerId, int inactive);
	
	@Query(value = "SELECT * FROM cfl_team_player WHERE player_id in (:ids) AND team_player_inactive = 0 ", nativeQuery = true)
	List<CFLTeamPlayers> findAllTeamPlayer(@Param("ids") List<Integer> id);
}
