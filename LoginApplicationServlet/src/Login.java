
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Dao dao = new Dao();

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("inside login");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		try {
			if (dao.readFromDatabase(username, password)) {
				dao.close();
				HttpSession session = request.getSession();
				session.setAttribute("username", username);
				response.sendRedirect("index.jsp");
			} else {
				dao.close();
//				request.setAttribute("message", "incorrect username and password");
//				request.getRequestDispatcher("/login.jsp").forward(request, response);
				response.sendRedirect("login.jsp");
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
