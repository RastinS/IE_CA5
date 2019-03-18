package Controllers;


import Database.Database;
import Models.Project;
import Models.User;
import Services.ProjectService;
import Services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet ("/project")
public class ProjectIdServlet extends HttpServlet {

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
	protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String  projectId = request.getParameter("projectId");
		Project project   = ProjectService.getProject(projectId);
		User    user      = UserService.getLoggedInUser();

		request.setCharacterEncoding("UTF-8");
		request.setAttribute("user", user);
		request.setAttribute("project", project);
		request.setAttribute("msg", "");
		request.getRequestDispatcher("oneProject.jsp").forward(request, response);
	}
}