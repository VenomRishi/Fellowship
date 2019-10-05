import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bridgelabz.repository.DbConnection;
import com.mysql.jdbc.PreparedStatement;

public class LoginDao {
	private Connection connection = null;
	private PreparedStatement preparedStatement = null;

	public boolean checkUser(String username, String password) throws ClassNotFoundException, SQLException {
		String query = "SELECT * FROM user WHERE username=? AND password=?";
		connection = DbConnection.getConnection();
		preparedStatement = (PreparedStatement) connection.prepareStatement(query);
		preparedStatement.setString(1, username);
		preparedStatement.setString(2, password);
		ResultSet rs = preparedStatement.executeQuery();
		if (rs.next())
			return true;

		return false;
	}
}
