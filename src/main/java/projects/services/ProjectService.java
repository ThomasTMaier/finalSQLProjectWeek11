package projects.services;

import java.util.function.Supplier;
import java.util.*;
import javax.print.PrintException;

import projects.dao.ProjectDao;
import projects.entity.Project;
import projects.exception.DbException;

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
	return  projectDao.fetchProjectById(projectId).orElseThrow(() -> new NoSuchElementException("project with project id: " + projectId + " does not exist"));
			

}

	public void deleteProject(Integer projectId) {
		// TODO Auto-generated method stub
		if(!projectDao.deleteProject(projectId)) {
			throw new DbException("Project with ID = " + projectId + " does not exist.");
		}
		
	}

	public void modifyProjectDetails(Project project) {
		// TODO Auto-generated method stub
		if(!projectDao.modifyProjectDetails(project)) {
			throw new DbException("Project with ID = " + project.getProjectId() + " does not exist.");
		}
	}
}