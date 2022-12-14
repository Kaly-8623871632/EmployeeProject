package com.boot.payload;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.boot.entity.AllocateProjectEntity;
import com.boot.entity.DepartmentEntity;
import com.boot.entity.EmployeeEntity;
import com.boot.entity.ProjectEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

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
public class ProjectDTO
{
     private int projectId;
     
     private String projectName; 
     
     private Date startDate;
     
     private Date endDate;
    
	private String projectStatus;
	
	@JsonIgnore
	private DepartmentDTO department;
	
	@JsonIgnore
	private List<AllocateProjectDTO> allocateProjectList = new ArrayList<>();
	
}