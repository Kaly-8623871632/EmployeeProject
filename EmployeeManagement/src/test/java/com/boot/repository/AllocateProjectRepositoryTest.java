package com.boot.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.boot.entity.AllocateProjectEntity;



public class AllocateProjectRepositoryTest {

	
	@Autowired
	private AllocateProjectRepository allocateProjectRepository;
	
	//given_when_then->BDD PATTERN 
	
	@Test
	@DisplayName("JUNIT testfor save student operation")
	public void givenAllocateProjectObject_whenSaveAllocateProject_thenReturnedSavedAllocateProject()
	{
		//given -precondition or setup
		AllocateProjectEntity allocateproject= AllocateProjectEntity .builder()
				                                                .projectStatus("Complate")
				                                      
				                                                .build();
		
		//when-action or behaviour that we are going to test
		AllocateProjectEntity savedAllocateProject = this. allocateProjectRepository.save( allocateproject);
		
		//then-verify the output
		Assertions.assertThat(savedAllocateProject).isNotNull();
		Assertions.assertThat(savedAllocateProject.getAllocateProjectId()).isGreaterThan(0);
		
	}	
}
