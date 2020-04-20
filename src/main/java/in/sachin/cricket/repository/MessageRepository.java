/**
 * 
 */
package in.sachin.cricket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.sachin.cricket.entity.CFLMessage;

/**
 * @author sachingoyal
 *
 */

@Repository("messageRepository")
public interface MessageRepository extends JpaRepository<CFLMessage, Integer>{

}
