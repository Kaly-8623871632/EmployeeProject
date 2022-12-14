package com.boot.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.boot.entity.StudentEntity;
@DataJpaTest
public class StudentRepositoryTests {

	@Autowired
	private StudentRepository studentRepository;
	
	//given_when_then->BDD PATTERN 
	
	@Test
	@DisplayName("JUNIT testfor save student operation")
	public void givenStudentObject_whenSaveStudent_thenReturnedSavedStudent()
	{
		//given -precondition or setup
		StudentEntity student= StudentEntity .builder()
				                                      .studentName("kalyani")
				                                      .studentAge(22)
				                                      .studentClass("MCA")
				                                      .studentEmail("kalyani@gmail.com")
				                                      .build();
		
		//when-action or behaviour that we are going to test
		StudentEntity savedStudent = this.studentRepository.save(student);
		
		//then-verify the output
		Assertions.assertThat(savedStudent).isNotNull();
		Assertions.assertThat(savedStudent.getStudentId()).isGreaterThan(0);
		
	}	
	}           
	
	
	
	
	
	
	
	
	
	

