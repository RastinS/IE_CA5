package Controllers;

import Models.User;
import Services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet ("/removeSkill")
public class RemoveUserSkillServlet extends HttpServlet {

	@Override
	protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String skillName = request.getParameter("skillName");
		String userId    = request.getParameter("userId");
		User   user      = UserService.findUserWithID(userId);
		if (UserService.deleteSkill(skillName, user)) {
			request.setAttribute("msg", "successfully deleted skill");
		} else {
			request.setAttribute("msg", "not delete skill !");
		}
		request.setAttribute("id", userId);
		request.getRequestDispatcher("user").forward(request, response);
	}
}
