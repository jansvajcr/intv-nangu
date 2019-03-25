package js.intv.nangu.dao;

import java.util.Collection;
import js.intv.nangu.Message;

/**
 * Data access object interface.
 */
public interface DAO {

	/**
	 * Returns all messages in the system.
	 *
	 * @return All messages
	 */
	Collection<Message> getMessages();

	/**
	 * Adds given message to the system.
	 *
	 * @param message Message to be added
	 */
	void addMessage(Message message);
}
