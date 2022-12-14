package com.boot.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.boot.entity.EmployeeEntity;



public class EmployeeRepositotyTests {

	
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	//given_when_then->BDD PATTERN 
	
	@Test
	@DisplayName("JUNIT testfor save student operation")
	public void givenEmployeeObject_whenSaveEmployee_thenReturnedSavedEmployee()
	{
		//given -precondition or setup
		EmployeeEntity employee= EmployeeEntity .builder()
				                                      .employeeName("kalyani")
				                                      .employeeAddress("pune")
				                                      .employeeSalary(40000)
				                                      .employeeGender("female")
				                                      .employeeContactNumber(123456787)
				                                      .employeeEmail("kalyani@gmail.com")
				                                    //  .employeeDOB("2022=02-12")  
				                                    //  .employeeDateOfJoin("2019-03-06")
				                                      .build();
		
		//when-action or behaviour that we are going to test
		EmployeeEntity savedEmployee = this.employeeRepository.save(employee);
		
		//then-verify the output
		Assertions.assertThat(savedEmployee).isNotNull();
		Assertions.assertThat(savedEmployee.getEmployeeId()).isGreaterThan(0);
		
	}	
	}           

