package js.intv.nangu.dao;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import js.intv.nangu.Message;

/**
 * In-memory DAO implementation for testing purposes.
 */
public class TestDAO implements DAO {

	private static final Collection<Message> DATA = new LinkedList<>();

	static {
		DATA.add(new Message("John", "Hey!"));
		DATA.add(new Message("Claire", "Hi there :-)"));
	}

	@Override
	public Collection<Message> getMessages() {
		return Collections.unmodifiableCollection(DATA);
	}

	@Override
	public void addMessage(Message message) {
		DATA.add(message);
	}
}
