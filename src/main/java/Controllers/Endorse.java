package Controllers;

import Services.UserService;
import ErrorClasses.HadEndorsedException;
import ErrorClasses.SkillNotFoundException;
import javax.servlet.http.HttpServletRequest;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Endorse {

	@RequestMapping(value = "/endorse", method = RequestMethod.POST)
	public ResponseEntity endorse(HttpServletRequest req) {
		try {
			JSONObject data = new JSONObject(req.getParameter("data"));
			UserService.endorseSkill(data.getString("usersID"), data.getString("skillName"));
			return ResponseEntity.ok("Endorsed succefully!");
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (SkillNotFoundException e) {
			return new ResponseEntity<>("skill not found" ,HttpStatus.NOT_FOUND);
		} catch (HadEndorsedException e) {
			return new ResponseEntity<>("Skill already endorsed", HttpStatus.FORBIDDEN);
		}
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

}

//data={"usersID"="2", "skillName"="HTML"}
