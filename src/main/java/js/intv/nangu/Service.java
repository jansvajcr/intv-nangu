package js.intv.nangu;

import java.util.stream.Collectors;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import js.intv.nangu.dao.DAO;
import js.intv.nangu.dao.DbDAO;

/**
 * Web service controller.
 */
@Path("/message")
public class Service {

	@GET
	@Path("/{author}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getMessages(@PathParam("author") String author) {
		return getDAO().getMessages().stream()
			.filter(m -> m.getAuthor().equals(author))
			.map(Message::toString)
			.collect(Collectors.joining(System.lineSeparator()));
	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getMessages() {
		return getDAO().getMessages().stream()
			.map(Message::toString)
			.collect(Collectors.joining(System.lineSeparator()));
	}

	@POST
	@Path("/{author}")
	@Consumes(MediaType.TEXT_PLAIN)
	public void addMessage(@PathParam("author") String author, String text) {
		getDAO().addMessage(new Message(author, text));
	}

	private static DAO getDAO() {
		return new DbDAO();
	}
}
