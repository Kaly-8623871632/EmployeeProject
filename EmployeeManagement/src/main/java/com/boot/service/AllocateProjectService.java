package com.boot.service;



import java.util.List;

import com.boot.payload.AllocateProjectDTO;

public interface AllocateProjectService
{
	public AllocateProjectDTO addAllocateProject(AllocateProjectDTO allocateProject);
	  
	  public List<AllocateProjectDTO> getAllallocateProjectList();
	  
	  public AllocateProjectDTO getAllocateProjectById(int allocateProjectId);
	  
	  public void deleteAllocateProjectById(int allocateProjectId);
	  
	  public AllocateProjectDTO updateAllocateProjectByID(AllocateProjectDTO allocateProject, int allocateProjectId);
	  
		public  List<AllocateProjectDTO> getAllocateProjectByProjectId(int projectId);
		
		public List<AllocateProjectDTO> getAllocateProjectByEmployeeId(int employeeId);

}