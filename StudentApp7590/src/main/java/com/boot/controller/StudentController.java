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
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.boot.exceptions.ApiResponse;
import com.boot.payload.StudentDTO;
import com.boot.service.StudentService;

@RestController
@RequestMapping("/student")
@CrossOrigin("*")
public class StudentController 
{
	@Autowired
	private StudentService studentService;
	
	@PostMapping// end point to add new record
	@RequestMapping(value="/",method=RequestMethod.POST)//end point or mapping method
	public ResponseEntity<StudentDTO> addStudent(@Valid @RequestBody StudentDTO student)
	{
		//ResponseEntity
	
		StudentDTO addStudent = this.studentService.addstudent(student);
		
		
   
		return new ResponseEntity<StudentDTO>(addStudent,HttpStatus.CREATED);
		//return addStudent;
		
	}
	
	@GetMapping("/")//end point to featch all student record
	public ResponseEntity<List<StudentDTO>> getAllStudents()
	{
		List<StudentDTO> allstudentList = this.studentService.getAllstudentList();
		return new ResponseEntity<List<StudentDTO>>(allstudentList,HttpStatus.OK);
		
   }
   
	@GetMapping("/{studentId}")
	public ResponseEntity<StudentDTO> getStudent(@PathVariable("studentId") int studentId)
	{
		StudentDTO studentObj = this.studentService.getStudentById(studentId);
		return new ResponseEntity<StudentDTO>(studentObj,HttpStatus.OK);
	}
	
	@PutMapping("/{studentId}")
	public ResponseEntity<StudentDTO> updateStudentById(@Valid @RequestBody StudentDTO student,@PathVariable("studentId") int studentId)
	{
		StudentDTO updatedStudent = this.studentService.updateStudentByID(student, studentId);
		return new ResponseEntity<StudentDTO>(updatedStudent,HttpStatus.OK);
	}

	@DeleteMapping("/{studentId}")
	public ResponseEntity<ApiResponse> deleteStudent(@PathVariable("studentId") int studentId)
	{
		this.studentService.deleteStudentById(studentId);
		
		ApiResponse response = new ApiResponse();//api is used to handle custum message 
		
		response.setMessage("student record deleted studentId "+"studentId");
		response.setStatus(true);
		
		return new ResponseEntity<ApiResponse>(response,HttpStatus.OK);
		
		
	}

}