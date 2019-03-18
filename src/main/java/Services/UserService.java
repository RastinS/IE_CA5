package Services;

import Database.Database;
import Models.Endorsement;
import Models.Project;
import Models.Skill;
import Models.User;
import Repositories.UserRepository;
import ErrorClasses.HadEndorsedException;
import ErrorClasses.HadSkillException;
import ErrorClasses.SkillNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class UserService {

	public static List<Project> findValidProjects (User user) {
		List<Project> validProjects = new ArrayList<Project>();
		for (Project project : Database.getProjects()) {
			if (canBid(project, user))
				validProjects.add(project);
		}
		return validProjects;
	}

	private static boolean canBid (Project project, User user) {
		for (Skill skill : project.getSkills()) {
			if (user.getSkillPoint(skill) < skill.getPoint())
				return false;
		}
		return true;
	}

	public static User findUserWithID (String select_ID) {
		for (User user : Database.getUsers()) {
			if (user.getId().equals(select_ID))
				return user;
		}
		return null;
	}

	public static List<User> getUsers () {
		List<User> users        = new ArrayList<>(Database.getUsers());
		User       loggedInUser = UserRepository.getLoggedInUser();

		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getId().equals(loggedInUser.getId())) {
				users.remove(i);
				return users;
			}
		}
		return users;
	}

	public static User getLoggedInUser () {
		return UserRepository.getLoggedInUser();
	}

	public static void addSkillToLoggedInUser (String skillName) throws HadSkillException, SkillNotFoundException {
		User loggedInUser = getLoggedInUser();

		if (!SkillService.isSkillValid(skillName)) {
			skillName = Character.toUpperCase(skillName.charAt(0)) + skillName.substring(1);
			if (!SkillService.isSkillValid(skillName))
				throw new SkillNotFoundException();
		}

		if (loggedInUser.hasSkill(skillName))
			throw new HadSkillException();
		getLoggedInUser().addSkill(new Skill(skillName));
	}

	public static void endorseSkill (String ID, String skillName) throws NullPointerException ,SkillNotFoundException, HadEndorsedException {
		User  user         = findUserWithID(ID);
		User  loggedInUser = getLoggedInUser();
		Skill skill        = user.getSkill(skillName);
		if (loggedInUser.hasEndorsed(skill))
			throw new HadEndorsedException();

		System.out.println(skill.getName());
		System.out.println(skill.getPoint());
		skill.addPoint();
		System.out.println(skill.getPoint());
		loggedInUser.addEndorsement(new Endorsement(loggedInUser, user, skill));
	}

	public static boolean deleteSkill (String skillName, User user) {
		return user.deleteSkill(skillName);
	}
}
