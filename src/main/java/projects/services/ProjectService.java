package projects.services;

import java.util.function.Supplier;
import java.util.*;!@
import javax.print.PrintException;

import projects.dao.ProjectDao;
import projects.entity.Project;

public class ProjectService {
	ProjectDao projectDao = new ProjectDao();

	public Project addProject(Project project) {

		return projectDao.insertProject(project);

	}

	public List<Project> fetchAllProjects() {
		// TODO Auto-generated method stub

		return projectDao.fetchAllProjects();
	}

	public Project fetchProjectById(Integer projectId) {
		// TODO Auto-generated method stub
	return  projectDao.fetchProjectById(projectId).orElseThrow(ArithmeticException :: new);
			
	

}
}