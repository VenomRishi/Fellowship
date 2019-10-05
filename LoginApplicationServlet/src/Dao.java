import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bridgelabz.model.User;
import com.bridgelabz.repository.DbConnection;
import com.mysql.jdbc.PreparedStatement;

public class Dao {
	private Connection connection = null;
	private PreparedStatement preparedStatement = null;

	public boolean readFromDatabase(String username, String password) throws ClassNotFoundException, SQLException {
		String query = "SELECT * FROM user WHERE username=? AND password=?";
		connection = DbConnection.getConnection();
		preparedStatement = (PreparedStatement) connection.prepareStatement(query);
		preparedStatement.setString(1, username);
		preparedStatement.setString(2, password);

		ResultSet rs = preparedStatement.executeQuery();
		if (rs.next()) {
			return true;
		}

		return false;
	}

	public boolean checkUsernameFromDatabase(String username) throws ClassNotFoundException, SQLException {
		String query = "SELECT * FROM user WHERE username=?";
		connection = DbConnection.getConnection();
		preparedStatement = (PreparedStatement) connection.prepareStatement(query);
		preparedStatement.setString(1, username);
		
		ResultSet rs = preparedStatement.executeQuery();
		if (rs.next()) {
			return true;
		}
		
		return false;
	}

	public boolean insertIntoDatabase(User user) throws SQLException, ClassNotFoundException {
		String query = "INSERT INTO user(fname,lname,username,password,dateupdated) VALUES(?,?,?,?,?)";
		connection = DbConnection.getConnection();
		preparedStatement = (PreparedStatement) connection.prepareStatement(query);

		preparedStatement.setString(1, user.getFname());
		preparedStatement.setString(2, user.getLname());
		preparedStatement.setString(3, user.getUsername());
		preparedStatement.setString(4, user.getPassword());
		preparedStatement.setString(5, user.getDateupdated());

		if (preparedStatement.executeUpdate() == 1)
			return true;

		return false;
	}

	public void close() throws SQLException {

		preparedStatement.close();
		connection.close();

	}
}
