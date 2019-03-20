package Controllers;

import Models.Bid;
import Models.Project;
import Models.User;
import Services.BidService;
import Services.ProjectService;
import Services.UserService;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class AddBid {

	@RequestMapping (value = "/addBid", method = RequestMethod.POST)
	public ResponseEntity addBid (HttpServletRequest req) {
		try {
			JSONObject data      = new JSONObject(req.getParameter("data"));
			int        bidAmount = Integer.parseInt(data.getString("bidAmount"));
			String     projectId = data.getString("projectID");
			String     userId    = data.getString("userID");
			User       user      = UserService.findUserWithID(userId);
			Project    project   = ProjectService.getProject(projectId);

			if (!BidService.isUserSuggested(project, user)) {
				if (BidService.isBidValidForProject(user, project, bidAmount)) {
					Bid bid = new Bid(user, project, bidAmount);
					project.addBid(bid);
					return ResponseEntity.ok("Your bid was successfully added :)");
				} else {
					return new ResponseEntity<>("Your bid is not valid !", HttpStatus.BAD_REQUEST);
				}
			} else {
				return new ResponseEntity<>("you can not bid again !", HttpStatus.BAD_REQUEST);
			}
		} catch (JSONException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}

//data={"bidAmount"="10000000", "projectID"="20955d46-0aac-4a6a-b546-d1581026663f", "userID"="1"}