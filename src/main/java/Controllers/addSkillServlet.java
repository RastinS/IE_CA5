package Controllers;

import Services.UserService;
import ErrorClasses.HadSkillException;
import ErrorClasses.SkillNotFoundException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet ("/addSkill")
public class addSkillServlet extends HttpServlet {
	@Override
	protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String skillName = req.getParameter("skillName");

		try {
			UserService.addSkillToLoggedInUser(skillName);
			req.setAttribute("msg", "Skill added successfully!");
		} catch (HadSkillException e) {
			req.setAttribute("msg", "Skill already in skill set.");
		} catch (SkillNotFoundException e) {
			req.setAttribute("msg", "Skill not in database.");
		}

		req.setAttribute("id", UserService.getLoggedInUser().getId());
		req.getRequestDispatcher("user").forward(req, resp);
	}
}
