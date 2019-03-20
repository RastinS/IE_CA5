package Controllers;

import Services.UserService;
import ErrorClasses.HadSkillException;
import ErrorClasses.SkillNotFoundException;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;

@RestController
public class AddSkill {

	@RequestMapping(value = "/addSkill", method = RequestMethod.POST)
	public ResponseEntity addSkill(HttpServletRequest req) {
		try {
			JSONObject data = new JSONObject(req.getParameter("data"));
			UserService.addSkillToLoggedInUser(data.getString("skillName"));
			return ResponseEntity.ok("Skill added successfully!");
		} catch (HadSkillException e) {
			return new ResponseEntity<>("Skill already in skill set.", HttpStatus.BAD_REQUEST);
		} catch (SkillNotFoundException e) {
			return new ResponseEntity<>("Skill not in database.", HttpStatus.BAD_REQUEST);
		} catch (JSONException e) {
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}

//data={"skillName"="Node.js"}