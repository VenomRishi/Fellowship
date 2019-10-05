
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bridgelabz.model.User;

/**
 * Servlet implementation class Register
 */
@WebServlet("/register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Dao dao = new Dao();
	private User user = new User();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		user.setFname(request.getParameter("fname"));
		user.setLname(request.getParameter("lname"));
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		LocalDateTime date = LocalDateTime.now();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		user.setDateupdated(format.format(date));
		try {
			if (!dao.checkUsernameFromDatabase(user.getUsername())) {
				if (dao.insertIntoDatabase(user)) {
					dao.close();
					HttpSession session = request.getSession();
					session.setAttribute("username", user.getUsername());
					response.sendRedirect("index.jsp");
				}
			} else {
				// user already available in database
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}