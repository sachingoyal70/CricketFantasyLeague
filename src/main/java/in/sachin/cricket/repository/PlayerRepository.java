/**
 * 
 */
package in.sachin.cricket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import in.sachin.cricket.entity.CFLPlayer;

/**
 * @author sachingoyal
 *
 */

@Repository("playerRepository")
public interface PlayerRepository extends JpaRepository<CFLPlayer, Integer> {

	CFLPlayer findByPlayerId(int id);

	@Query(value = "SELECT * FROM cfl_player WHERE player_id in (:ids)", nativeQuery = true)
	List<CFLPlayer> findAllTeamPlayer(@Param("ids") List<Integer> id);

	@Query(value = "SELECT id,player_id,player_name,player_team,player_role,player_value,player_run,player_fours,player_sixes,player_wicket,player_score,player_percentage,player_profile,player_image,player_current_score, RANK() OVER(ORDER BY player_current_score DESC) ranks FROM cfl_player ORDER BY ranks LIMIT 5", nativeQuery = true)
	List<CFLPlayer> findTopTeamPlayer();

	@Query(value = "SELECT id,player_id,player_name,player_team,player_role,player_value,player_run,player_fours,player_sixes,player_wicket,player_score,player_percentage,player_profile,player_image,player_current_score, RANK() OVER(ORDER BY player_current_score DESC) ranks FROM cfl_player ORDER BY ranks", nativeQuery = true)
	List<CFLPlayer> findAllTeamPlayer();

	@Query(value = "SELECT * FROM cfl_player WHERE player_id not in (:ids) and player_role in (:roles)", nativeQuery = true)
	List<CFLPlayer> findAllTeamPlayerforModify(@Param("ids") List<Integer> id, @Param("roles") List<String> role);

}
