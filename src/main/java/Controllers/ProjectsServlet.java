package Controllers;

import Models.Project;
import Services.ProjectService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet ("/projects")
public class ProjectsServlet extends HttpServlet {

	@Override
	protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Project> projects = ProjectService.getProjects();
		req.setAttribute("projects", projects);
		req.getRequestDispatcher("projects.jsp").forward(req, resp);
	}
}