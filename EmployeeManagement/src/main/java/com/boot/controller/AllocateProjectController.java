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
import com.boot.payload.AllocateProjectDTO;
import com.boot.service.AllocateProjectService;


@RestController
@RequestMapping("/allocateProject")
@CrossOrigin("*")
public class AllocateProjectController
{
	@Autowired
	private AllocateProjectService allocateProjectService;
	
	@PostMapping// end point to add new record
	@RequestMapping(value="/",method=RequestMethod.POST)//end point or mapping method
	public ResponseEntity<AllocateProjectDTO> addAllocateProject(@Valid @RequestBody AllocateProjectDTO allocateProject)
	{
		//ResponseEntity
	
		AllocateProjectDTO addAllocateProject = this.allocateProjectService.addAllocateProject(allocateProject);
		
		
   
		return new ResponseEntity<AllocateProjectDTO>(addAllocateProject,HttpStatus.CREATED);
		//return addEmployee;
		
	}
	
	@GetMapping("/")//end point to featch all employee record
	public ResponseEntity<List<AllocateProjectDTO>> getAllAllocateProject()
	{
		List<AllocateProjectDTO> allallocateProjectList = this.allocateProjectService.getAllallocateProjectList();
		return new ResponseEntity<List<AllocateProjectDTO>>(allallocateProjectList,HttpStatus.OK);
		
   }
   
	@GetMapping("/{allocateProjectId}")
	public ResponseEntity<AllocateProjectDTO> getAllocateProject(@PathVariable("allocateProjectId") int allocateProjectId)
	{
		AllocateProjectDTO allocateProjectObj = this.allocateProjectService.getAllocateProjectById(allocateProjectId);
		return new ResponseEntity<AllocateProjectDTO>(allocateProjectObj,HttpStatus.OK);
	}
	
	@PutMapping("/{allocateProjectId}")
	public ResponseEntity<AllocateProjectDTO> updateAllocateProjectById(@Valid @RequestBody AllocateProjectDTO allocateProject,@PathVariable("allocateProjectId") int allocateProjectId)
	{
		AllocateProjectDTO updatedAllocateProject = this.allocateProjectService.updateAllocateProjectByID(allocateProject, allocateProjectId);
		return new ResponseEntity<AllocateProjectDTO>(updatedAllocateProject,HttpStatus.OK);
	}

	@DeleteMapping("/{allocateProjectId}")
	public ResponseEntity<ApiResponse> deleteAllocateProject(@PathVariable("allocateProjectId") int allocateProjectId)
	{
		this.allocateProjectService.deleteAllocateProjectById(allocateProjectId);
		
		ApiResponse response = new ApiResponse();//api is used to handle custum message 
		
		response.setMessage("Allocated Project record is deleted with allocated project Id: "+allocateProjectId);
		response.setStatus(true);
		
		return new ResponseEntity<ApiResponse>(response,HttpStatus.OK);
		
		
	}
	
	@GetMapping("/project/{projectId}")
	public ResponseEntity<List<AllocateProjectDTO>>getAllAllocateProjectByProjectId(@PathVariable("projectId") int projectId)
	{
		List<AllocateProjectDTO> allocateprojectList= this.allocateProjectService.getAllocateProjectByProjectId(projectId);
	   return new ResponseEntity<List<AllocateProjectDTO>>(allocateprojectList,HttpStatus.OK);	
	}


	@GetMapping("/employee/{employeeId}")
	public ResponseEntity<List<AllocateProjectDTO>>getAllAllocateProjectByemployeeId(@PathVariable("employeeId") int employeeId)
	{
		List<AllocateProjectDTO> allocateprojectList= this.allocateProjectService.getAllocateProjectByEmployeeId(employeeId);
	   return new ResponseEntity<List<AllocateProjectDTO>>(allocateprojectList,HttpStatus.OK);	
	}

}