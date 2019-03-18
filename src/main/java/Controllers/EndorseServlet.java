package Controllers;

import Services.UserService;
import ErrorClasses.HadEndorsedException;
import ErrorClasses.SkillNotFoundException;
import javafx.util.Pair;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet ("/endorse")
public class EndorseServlet extends HttpServlet {
	private static Pair<String, String> parseNextCommand (String line) {
		int spacePos = line.indexOf(" ");
		return new Pair<>(line.substring(0, spacePos), line.substring(spacePos + 1));
	}

	@Override
	protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Pair<String, String> command = parseNextCommand(req.getParameter("skillName"));
		try {
			UserService.endorseSkill(command.getKey(), command.getValue());
			req.setAttribute("msg", "Endorsed successfully!");
		} catch (SkillNotFoundException e) {
			req.setAttribute("msg", "Skill not found");
		} catch (HadEndorsedException e) {
			req.setAttribute("msg", "Skill already endorsed");
		}

		req.setAttribute("id", command.getKey());
		req.getRequestDispatcher("user").forward(req, resp);
	}
}
