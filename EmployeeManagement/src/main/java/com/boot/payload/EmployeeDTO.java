package com.boot.payload;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.boot.entity.AllocateProjectEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

//import com.boot.entity.DepartmentEntity;
//import com.boot.entity.EmployeeEntity;
//import com.boot.entity.ProjectEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
	
	
	private int employeeId;
	
	private String employeeName;
	
	private String employeeAddress;
	
	private int employeeSalary;
	
	 private String employeeGender;
	 
	 private long employeeContactNumber;
	 
	 private String employeeEmail;
	 
	 private String password;

	private Date employeeDOB;

    private Date employeeDateOfJoin;
    
     private DepartmentDTO department;

	
    
   @JsonIgnore
	private List<AllocateProjectDTO> allocateProjectList = new ArrayList<>();
	 }