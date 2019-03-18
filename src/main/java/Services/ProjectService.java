package Services;

import Database.Database;
import Models.Project;

import java.util.List;

public class ProjectService {
	public static Project getProject (String id) {
		for (Project project : Database.getProjects()) {
			if (project.getId().equals(id)) {
				return project;
			}
		}
		return new Project();
	}

	public static List<Project> getProjects () {
		return Database.getProjects();
	}
}
