package Services;

import Models.Bid;
import Models.Project;
import Models.Skill;
import Models.User;

public class BidService {

    public static boolean isUserSuggested(Project project, User user) {
        for (Bid bid : project.getBids()) {
            if (bid.getBiddingUser().getId().equals(user.getId())) {
                return true;
            }
        }
        return false;
    }

    public static boolean isBidValidForProject(User user, Project project, int bidAmount) {
        if(bidAmount > project.getBudget())
            return false;
        for(Skill skill : project.getSkills()) {
            if(user.getSkillPoint(skill) < skill.getPoint()) {
                return false;
            }
        }
        return true;
    }
}
