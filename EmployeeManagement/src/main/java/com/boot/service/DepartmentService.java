package com.boot.service;

import java.util.List;

import com.boot.payload.DepartmentDTO;
import com.boot.payload.EmployeeDTO;



public interface DepartmentService
{
	
	
	 public DepartmentDTO addDepartment(DepartmentDTO department);
		
		public List<DepartmentDTO> getAllDepartmentList();
		
		public DepartmentDTO getDepartmentById(int departmentId);
		
		public void deleteDepartmentById(int departmentId);
		
		public DepartmentDTO updateDepartmentById(DepartmentDTO department,int departmentId);
		
//		 public List<DepartmentDTO> getAlldepartmentByprojectId(int projectId);

}