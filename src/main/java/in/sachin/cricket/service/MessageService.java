/**
 * 
 */
package in.sachin.cricket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.sachin.cricket.entity.CFLMessage;
import in.sachin.cricket.repository.MessageRepository;

/**
 * @author sachingoyal
 *
 */

@Service("messageService")
public class MessageService {

	private MessageRepository messageRepository;

	@Autowired
	public MessageService(MessageRepository messageRepository) {
		this.messageRepository = messageRepository;
	}

	public void saveMsg(CFLMessage message) {
		messageRepository.save(message);
	}

}
