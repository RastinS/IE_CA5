package Controllers;

import Database.Database;
import Models.User;
import Services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;


@WebServlet ("/user")
public class userDisplayServlet extends HttpServlet {
	@Override
	public void init () throws ServletException {
		super.init();
		if (!Database.didInit()) {
			try {
				Database.init();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userID;
		if (req.getAttribute("msg") != null)
			userID = (String) req.getAttribute("id");
		else
			userID = req.getParameter("id");

		User user = UserService.findUserWithID(userID);
		req.setAttribute("user", user);

		if (Objects.equals(user, UserService.getLoggedInUser()))
			req.setAttribute("canEndorse", "no");
		else
			req.setAttribute("canEndorse", "yes");

		req.getRequestDispatcher("userDisplay.jsp").forward(req, resp);
	}
}
