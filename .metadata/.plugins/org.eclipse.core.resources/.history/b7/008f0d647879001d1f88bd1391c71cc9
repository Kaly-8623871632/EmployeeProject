package com.boot.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.boot.exception.ApiResponse;
import com.boot.payload.EmployeeDTO;

import com.boot.service.EmployeeService;


@RestController
@RequestMapping("/employee")
@CrossOrigin("*")
public class EmployeeController 
{
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping// end point to add new record
	@RequestMapping(value="/",method=RequestMethod.POST)//end point or mapping method
	public ResponseEntity<EmployeeDTO> addEmployee(@Valid @RequestBody EmployeeDTO employee)
	{
		//ResponseEntity
	
		EmployeeDTO addEmployee = this.employeeService.addemployee(employee);
		
		
   
		return new ResponseEntity<EmployeeDTO>(addEmployee,HttpStatus.CREATED);
		//return addEmployee;
		
	}
	
	@GetMapping("/")//end point to featch all employee record
	public ResponseEntity<List<EmployeeDTO>> getAllEmployeeList()
	{
		List<EmployeeDTO> allemployeeList = this.employeeService.getAllemployeeList();
		return new ResponseEntity<List<EmployeeDTO>>(allemployeeList,HttpStatus.OK);
		
   }
   
	@GetMapping("/{employeeId}")
	public ResponseEntity<EmployeeDTO> getEmployee(@PathVariable("employeeId") int employeeId)
	{
		EmployeeDTO employeeObj = this.employeeService.getEmployeeById(employeeId);
		return new ResponseEntity<EmployeeDTO>(employeeObj,HttpStatus.OK);
	}
	
	@PutMapping("/{employeeId}")
	public ResponseEntity<EmployeeDTO> updateEmployeeById(@Valid @RequestBody EmployeeDTO employee,@PathVariable("employeeId") int employeeId)
	{
		EmployeeDTO updatedEmployee = this.employeeService.updateEmployeeByID(employee, employeeId);
		return new ResponseEntity<EmployeeDTO>(updatedEmployee,HttpStatus.OK);
	}

	@DeleteMapping("/{employeeId}")
	public ResponseEntity<ApiResponse> deleteEmployee(@PathVariable("employeeId") int employeeId)
	{
		this.employeeService.deleteEmployeeById(employeeId);
		
		ApiResponse response = new ApiResponse();//api is used to handle custum message 
		
		response.setMessage("employee record is deleted with employee Id: "+employeeId);
		response.setStatus(true);
		
		return new ResponseEntity<ApiResponse>(response,HttpStatus.OK);
		
		
	}
	
	@GetMapping("/department/{departmentId}")
	public ResponseEntity<List<EmployeeDTO>> getEmployeeBydeprtmentId(@PathVariable("departmentId") int departmentId)
	{
		List<EmployeeDTO> employeeObj = this.employeeService.getAllemployeeBydepartmentId(departmentId);
		return new ResponseEntity<List<EmployeeDTO>>(employeeObj,HttpStatus.OK);
	}
	
	
	
	
	
	@GetMapping("/check")
	public ResponseEntity<EmployeeDTO> login()
	{
		String employeeEmail="pragati@gmail.com";
		String password="12345";
		
		EmployeeDTO checkedLogin=this.employeeService.checkLogin(employeeEmail, password);
		return new ResponseEntity<EmployeeDTO>(checkedLogin,HttpStatus.OK);
	}

}