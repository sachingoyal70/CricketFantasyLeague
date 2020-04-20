/**
 * 
 */
package in.sachin.cricket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.sachin.cricket.entity.CFLPlayer;

/**
 * @author sachingoyal
 *
 */

@Repository("playerRepository")
public interface PlayerRepository extends JpaRepository<CFLPlayer, Integer>{

}
