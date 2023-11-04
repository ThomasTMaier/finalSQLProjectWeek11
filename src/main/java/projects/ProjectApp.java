package projects;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.math.BigDecimal;

import projects.entity.Project;
import projects.exception.DbException;
import projects.services.ProjectService;


public class ProjectApp {
	
	private	ProjectService projectService = new ProjectService();
	
	
//@formatter:off
	
	private List <String> operations = List.of(
			"1) Add a project." 
			
			);
//@formatter:on
	private Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ProjectApp().processUserSelection();
		
	}
	private void processUserSelection() {
		// TODO Auto-generated method stub
		boolean done = false;
		while(!done) {
			try{
				int selection = getUserSelection();
				switch(selection) {
				case -1:
					done = exitMenu();
					break;
				case 1:
					createProject();
					break;
				default: 
					System.out.println("\n" + selection + " is not a valid selection, please try again");
				
				}
			}catch(Exception e) {
				System.out.println("\nError:" + e + "Try again.");
			}
			
		}
				
	}
	private void createProject() {
		// TODO Auto-generated method stub
		String projectName =  getStringInput("Enter the Project name");
		BigDecimal estimatedHours = getDecimalInput("Enter the estimated hours");
		BigDecimal actualHours = getDecimalInput ("Enter the actual hours");
		Integer difficulty = getIntInput("Enter the project difficulty (1-5)");
		String notes = getStringInput( "Enter the project notes"); 
		
		Project project = new Project();
		
		project.setProjectName(projectName);
		project.setEstimatedHours(estimatedHours);
		project.setActualHours(actualHours);
		project.setDifficulty(difficulty);
		project.setNotes(notes);
		
		Project dbProject = projectService.addProject(project);
		System.out.println("You have successfully created project: " + dbProject);
	}
	private java.math.BigDecimal getDecimalInput(String string) {
		String input = getStringInput(string);
		if(Objects.isNull(input)) {
			return null;
		}
		try {
			return new BigDecimal(input).setScale(2);
		}catch(NumberFormatException e) {
			throw new DbException(input + " is not a valid decimal number");
		}
	}
	private boolean exitMenu() {
		// TODO Auto-generated method stub
		System.out.println("Exiting the menu");
		return true;
		
	}
	private int getUserSelection() {
		printOperations();
		Integer input = getIntInput("Enter a menu Selection");
		return Objects.isNull(input) ? -1 :input;
	}
	private Integer getIntInput(String string) {
		String input = getStringInput(string);
		if(Objects.isNull(input)) {
			return null;
		}
		try {
			return Integer.valueOf(input);
		}catch(NumberFormatException e) {
			throw new DbException(input + " is not a valid number");
		}
		
	}
	private String getStringInput(String prompt) {
		System.out.print(prompt+ ": " );
		String input = scan.nextLine();
		return input.isBlank() ? null: input.trim();
	}
	private void printOperations() {
		// TODO Auto-generated method stub
		System.out.println("\nThese are the available selections. Press the enter key to quit.");
		operations.forEach(line -> System.out.println(" " + line));
	}
	
	

}
