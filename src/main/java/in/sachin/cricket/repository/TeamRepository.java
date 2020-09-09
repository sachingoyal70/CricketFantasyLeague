/**
 * 
 */
package in.sachin.cricket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import in.sachin.cricket.entity.CFLTeam;

/**
 * @author sachingoyal
 *
 */

@Repository("teamRepository")
public interface TeamRepository extends JpaRepository<CFLTeam, Integer> {

	@Query(value = "SELECT id,team_owner,team_name,team_today_score,team_user,team_enabled,team_score,team_current_score,team_modified,team_creation_date,team_last_modified,team_substitution_left, RANK() OVER(ORDER BY team_current_score DESC) ranks FROM cfl_team WHERE team_owner = ?1 ORDER BY ranks",nativeQuery = true)
	CFLTeam findByOwner(String ownerEmail);

	CFLTeam findById(int id);

	List<CFLTeam> findByTeamEnabled(int enabled);

	@Query(value = "SELECT id,team_owner,team_name,team_user,team_today_score,team_enabled,team_score,team_current_score,team_modified,team_creation_date,team_last_modified,team_substitution_left, RANK() OVER(ORDER BY team_current_score DESC) ranks FROM cfl_team WHERE team_enabled = 1 ORDER BY ranks LIMIT 5", nativeQuery = true)
	List<CFLTeam> findTopTeam();
	
	@Query(value = "SELECT id,team_owner,team_name,team_user,team_enabled,team_today_score,team_score,team_current_score,team_modified,team_creation_date,team_last_modified,team_substitution_left, RANK() OVER(ORDER BY team_current_score DESC) ranks FROM cfl_team WHERE team_enabled = 1 ORDER BY ranks", nativeQuery = true)
	List<CFLTeam> findAllTeam();
	
	@Query(value = "SELECT count(*) from cfl_team", nativeQuery = true)
	int getTeamCount();
	
	
	@Query(value = "SELECT id,team_owner,team_name,team_user,team_enabled,team_today_score,team_score,team_current_score,team_modified,team_creation_date,team_last_modified,team_substitution_left, ROW_NUMBER() OVER(ORDER BY team_current_score DESC) ranks FROM cfl_team WHERE id in (:ids) ORDER BY ranks", nativeQuery = true)
	List<CFLTeam> getMyLeaderBoardTeam(@Param("ids") List<Integer> id);

}
