package com.boot.payload;


import com.boot.entity.AllocateProjectEntity;
import com.boot.entity.EmployeeEntity;
import com.boot.entity.ProjectEntity;

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
public class AllocateProjectDTO 
{
    
	private int allocateProjectId;
	
	private String projectStatus;
	
	private EmployeeDTO employee;
	
	private ProjectDTO project;

}