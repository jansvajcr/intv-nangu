package js.intv.nangu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import js.intv.nangu.Message;

/**
 * SQL database DAO implementation.
 */
public class DbDAO implements DAO {

	@Override
	public Collection<Message> getMessages() {
		List<Message> result = new ArrayList<>();
		try (Connection connection = Database.getConnection()) {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT author, text FROM message");
			while (resultSet.next()) {
				result.add(new Message(resultSet.getString("author"), resultSet.getString("text")));
			}
		} catch (SQLException ex) {
			Logger.getLogger(DbDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
		return result;
	}

	@Override
	public void addMessage(Message message) {
		try (Connection connection = Database.getConnection()) {
			PreparedStatement statement = connection.prepareStatement("INSERT INTO message (author, text) VALUES (?, ?)");
			statement.setString(1, message.getAuthor());
			statement.setString(2, message.getMessage());
			statement.executeUpdate();
		} catch (SQLException ex) {
			Logger.getLogger(DbDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
