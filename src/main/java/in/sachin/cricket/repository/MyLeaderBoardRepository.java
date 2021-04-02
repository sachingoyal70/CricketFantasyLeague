/**
 * 
 */
package in.sachin.cricket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.sachin.cricket.entity.CFLMyLeaderboard;

/**
 * @author sachingoyal
 *
 */
@Repository("myLeaderboardRepository")
public interface MyLeaderBoardRepository extends JpaRepository<CFLMyLeaderboard, Integer> {

	List<CFLMyLeaderboard> findByEmail(String email);

}
