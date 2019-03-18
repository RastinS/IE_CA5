package Controllers;

import Models.User;
import Services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.sun.istack.internal.NotNull;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RemoveSkill {

	@RequestMapping(value = "/removeSkill", method = RequestMethod.POST)
	public ResponseEntity removeSkill(HttpServletRequest req) {

		try {
			JSONObject data = new JSONObject(req.getParameter("data"));
			String selfID = data.getString("selfID");
			if(selfID.equals("0"))
				return new ResponseEntity<>("login first!", HttpStatus.UNAUTHORIZED);

			if(UserService.deleteSkill(data.getString("skillName"), UserService.findUserWithID(selfID)))
				return ResponseEntity.ok("deleted successfully!");
			else
				return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

}

//data={"skillName"="HTML", "userID"="1"}
