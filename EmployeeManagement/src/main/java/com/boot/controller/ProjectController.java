package com.boot.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.boot.exception.ApiResponse;
import com.boot.payload.EmployeeDTO;
import com.boot.payload.ProjectDTO;

import com.boot.service.ProjectService;


@RestController
@RequestMapping("/project")
@CrossOrigin("*")
public class ProjectController
{
	
	@Autowired
	 private ProjectService projectService;
	
	@PostMapping("/addProject")
	@RequestMapping(value="/",method=RequestMethod.POST)
	public ResponseEntity<ProjectDTO> project(@Valid @RequestBody ProjectDTO projectDTO)
	{
		ProjectDTO project =this.projectService.addProject(projectDTO);
	    return new ResponseEntity<ProjectDTO>(projectDTO,HttpStatus.CREATED);
	}
 
	
	@GetMapping("/")
	public ResponseEntity<List<ProjectDTO>> getAllProjects()
	{
		
		List<ProjectDTO> projectList = this.projectService.getAllProject();
		return new ResponseEntity<List<ProjectDTO>>(projectList,HttpStatus.OK);
		
  }
	
	@GetMapping("/{projectId}")
	public ResponseEntity<ProjectDTO> getProjectById(@PathVariable("projectId") int projectId)
	{
		ProjectDTO  project = this.projectService.getProjectById(projectId);
		return new ResponseEntity<ProjectDTO>(project,HttpStatus.OK);
	}
	
	@PutMapping("/{projectId}")
	public ResponseEntity<ProjectDTO> updateProjectById(@Valid @RequestBody ProjectDTO project,@PathVariable("projectId") int projectId)
	{
		ProjectDTO updatedProject = this.projectService.updateProjectByID(project, projectId);
		return new ResponseEntity<ProjectDTO>(updatedProject,HttpStatus.OK);
	}

	@DeleteMapping("/{projectId}")
	public ResponseEntity<ApiResponse> deleteProject(@PathVariable("projectId") int projectId)
	{
		this.projectService.deleteProjectById(projectId);
		
		ApiResponse response = new ApiResponse();//api is used to handle custum message 
		
		response.setMessage("project record is deleted with project Id: "+projectId);
		response.setStatus(true);
		
		return new ResponseEntity<ApiResponse>(response,HttpStatus.OK);
		
		
	}
  
	
//	@GetMapping("/department/{departmentId}")
//	public ResponseEntity<List<ProjectDTO>>getAllProjectByDepartmentId(@PathVariable("departmentId") int departmentId)
//	{
//		List<ProjectDTO> projectList= this.projectService.getProjectByDepartmentId(departmentId);
//	   return new ResponseEntity<List<ProjectDTO>>(projectList,HttpStatus.OK);	
//	}
//
//
//	@GetMapping("/employee/{employeeId}")
//	public ResponseEntity<List<ProjectDTO>>getAllProjectByemployeeId(@PathVariable("employeeId") int employeeId)
//	{
//		List<ProjectDTO> projectList= this.projectService.getProjectByEmployeeId(employeeId);
//	   return new ResponseEntity<List<ProjectDTO>>(projectList,HttpStatus.OK);	
//	}

}