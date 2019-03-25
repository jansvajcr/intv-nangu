package js.intv.nangu;

/**
 * Message value object.
 */
public class Message {

	private final String author;
	private final String message;

	public Message(String author, String message) {
		this.author = author;
		this.message = message;
	}

	public String getAuthor() {
		return author;
	}

	public String getMessage() {
		return message;
	}

	@Override
	public String toString() {
		return String.format("Message(%s,%s)", message, author);
	}
}
