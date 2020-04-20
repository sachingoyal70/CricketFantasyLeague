/**
 * 
 */
package in.sachin.cricket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.sachin.cricket.entity.CFLNoticeBoard;
import in.sachin.cricket.repository.NoticeBoardRepository;

/**
 * @author sachingoyal
 *
 */

@Service("noticeboardservice")
public class NoticeBoardService {

	private NoticeBoardRepository noticeBoardRepository;

	@Autowired
	public NoticeBoardService(NoticeBoardRepository noticeBoardRepository) {
		this.noticeBoardRepository = noticeBoardRepository;
	}

	public List<CFLNoticeBoard> getAllNotices() {
		return noticeBoardRepository.findAll();
	}

}
