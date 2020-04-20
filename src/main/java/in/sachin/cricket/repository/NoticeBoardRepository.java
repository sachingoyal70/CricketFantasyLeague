/**
 * 
 */
package in.sachin.cricket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.sachin.cricket.entity.CFLNoticeBoard;

/**
 * @author sachingoyal
 *
 */

@Repository("noticeRepository")
public interface NoticeBoardRepository extends JpaRepository<CFLNoticeBoard, Integer> {

}
