package Controllers;

import Models.Bid;
import Models.Project;
import Models.User;
import Services.BidService;
import Services.ProjectService;
import Services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet ("/addBid")
public class AddBidServlet extends HttpServlet {

	@Override
	protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bidAmount = Integer.parseInt(request.getParameter("bidAmount"));
		String  projectId = request.getParameter("projectId");
		String  userId    = request.getParameter("userId");
		User    user      = UserService.findUserWithID(userId);
		Project project   = ProjectService.getProject(projectId);

		System.out.println(userId);
		if (!BidService.isUserSuggested(project, user)) {
			if(BidService.isBidValidForProject(user, project, bidAmount)) {
				Bid bid = new Bid(user, project, bidAmount);
				project.addBid(bid);
				request.setAttribute("msg", "your bid successfully added :)");
			} else {
				request.setAttribute("msg", "your bid is not valid !");
			}
		} else {
			request.setAttribute("msg", "you can not bid again !");
		}
		request.setAttribute("user", user);
		request.setAttribute("project", project);
		request.getRequestDispatcher("oneProject.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
