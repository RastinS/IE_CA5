package Controllers;

import Models.Project;
import Repositories.ProjectRepository;
import Services.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class GetProjects{

	@RequestMapping(value = "/projects", method = RequestMethod.GET)
	public ResponseEntity getProjects() {
		List<Project> projects = ProjectRepository.getProjects();
		if(projects.size() != 0)
			return ResponseEntity.ok(projects);
		else
			return new ResponseEntity<>("Couldn't fetch projects list from database!",HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@RequestMapping(value = "/projects/{id}", method = RequestMethod.GET)
	public ResponseEntity getProject(@PathVariable String id) {
		Project project = ProjectService.getProject(id);
		if(project != null)
			return ResponseEntity.ok(project);
		else
			return new ResponseEntity<>("project not found with this ID!", HttpStatus.NOT_FOUND);
	}
}
