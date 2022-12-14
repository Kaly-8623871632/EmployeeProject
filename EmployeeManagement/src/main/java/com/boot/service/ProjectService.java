package com.boot.service;

import java.util.List;

import com.boot.payload.EmployeeDTO;
import com.boot.payload.ProjectDTO;



public interface ProjectService
{
	
	 public ProjectDTO addProject(ProjectDTO project);
		
		public List<ProjectDTO> getAllProject();
		
		public  ProjectDTO getProjectById(int projectId);
		
		public void deleteProjectById(int projectId);
		  
		  public ProjectDTO updateProjectByID(ProjectDTO project, int projectId);
	


}