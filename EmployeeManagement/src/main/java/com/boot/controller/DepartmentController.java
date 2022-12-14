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
import org.springframework.web.bind.annotation.RestController;

import com.boot.exception.ApiResponse;
import com.boot.payload.DepartmentDTO;
import com.boot.payload.EmployeeDTO;
import com.boot.service.DepartmentService;



@RestController
@RequestMapping("/department")
@CrossOrigin("*")
public class DepartmentController 
{
	
	@Autowired
	private DepartmentService departmentService;
	
	@PostMapping("/")
    public ResponseEntity<DepartmentDTO> addDepartment(@Valid @RequestBody DepartmentDTO departmentDTo)
    {
		DepartmentDTO addedDepartment = this.departmentService.addDepartment(departmentDTo);
    
    	return new ResponseEntity<DepartmentDTO>(addedDepartment,HttpStatus.CREATED);
    }
	
	@GetMapping("/")
	public ResponseEntity<List<DepartmentDTO>> getAllDepartments()
	{
		List<DepartmentDTO> departmentList = this.departmentService.getAllDepartmentList();
		return new ResponseEntity<List<DepartmentDTO>>(departmentList,HttpStatus.OK);
		
   }
   
	@GetMapping("/{departmentId}")
	public ResponseEntity<DepartmentDTO> getDepartmentById(@PathVariable("departmentId") int departmentId)
	{
		DepartmentDTO  department = this.departmentService.getDepartmentById(departmentId);
		return new ResponseEntity<DepartmentDTO>(department,HttpStatus.OK);
	}
	
	@PutMapping("/{departmentId}")
	public ResponseEntity<DepartmentDTO> updateDepartmentById(@Valid @RequestBody DepartmentDTO department,@PathVariable("departmentId") int departmentId)
	{
		DepartmentDTO updatedDepartment = this.departmentService.updateDepartmentById(department, departmentId);
		return new ResponseEntity<DepartmentDTO>(updatedDepartment,HttpStatus.OK);
	}
	
	@DeleteMapping("/{departmentId}")
	public ResponseEntity<ApiResponse> deleteDepartment(@PathVariable("departmentId")int departmentId)
	{
		this.departmentService.deleteDepartmentById(departmentId);
		
		ApiResponse response=new ApiResponse();
		
		response.setMessage("department record is deleted with department Id: "+departmentId);
		
		response.setStatus(true);
		//return null;
	    return new ResponseEntity<ApiResponse>(response,HttpStatus.OK);
	    			
	}
//	@GetMapping("/project/{projectId}")
//	public ResponseEntity<List<DepartmentDTO>> getDepartmentByprojectId(@PathVariable("projectId") int projectId)
//	{
//		List<DepartmentDTO> departmentObj = this.departmentService.getAlldepartmentByprojectId(projectId);
//		return new ResponseEntity<List<DepartmentDTO>>(departmentObj,HttpStatus.OK);
//	}

}