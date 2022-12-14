package com.boot.serviceimplementation;


import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.entity.AllocateProjectEntity;
import com.boot.exception.ResourceNotFoundException;
import com.boot.payload.AllocateProjectDTO;
import com.boot.repository.AllocateProjectRepository;
import com.boot.repository.ProjectRepository;
import com.boot.repository.EmployeeRepository;
import com.boot.service.AllocateProjectService;

@Service
public class AllocateProjectServiceImplementation implements AllocateProjectService
{
	@Autowired
	private AllocateProjectRepository allocateProjectRepository;
	
	@Autowired
	private ProjectRepository projectRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	

    @Override
	public AllocateProjectDTO addAllocateProject(AllocateProjectDTO  allocateProject) {
		// TODO Auto-generated method stub
    	AllocateProjectEntity  allocateProjectEntity = this.modelMapper.map(allocateProject, AllocateProjectEntity .class);
		
    	AllocateProjectEntity  savedAllocateProjectEntity  =this.allocateProjectRepository.save(allocateProjectEntity);
		
    
		return this.modelMapper.map(savedAllocateProjectEntity , AllocateProjectDTO.class);
		
    	
	}
	@Override
	public List<AllocateProjectDTO> getAllallocateProjectList() {
		// TODO Auto-generated method stub
		List<AllocateProjectEntity > allocateProjectList =this.allocateProjectRepository.findAll();
		List<AllocateProjectDTO>  allocateProjectListDto = allocateProjectList.stream().map(allocateProject->this.modelMapper.map(allocateProject, AllocateProjectDTO.class))
				.collect(Collectors.toList());
		return allocateProjectListDto;
		
		
	}
	@Override
	public AllocateProjectDTO getAllocateProjectById(int allocateProjectId) {
		// TODO Auto-generated method stub
		
		AllocateProjectEntity allocateProjectObj = this.allocateProjectRepository
				.findById(allocateProjectId).orElseThrow(()-> new ResourceNotFoundException("allocateProject","allocateProjectId",allocateProjectId));
				return this.modelMapper.map(allocateProjectObj, AllocateProjectDTO.class);
		
	}
	@Override
	public void deleteAllocateProjectById(int allocateProjectId) {
		// TODO Auto-generated method stub
		if(this.allocateProjectRepository.existsById(allocateProjectId)) 
		{
			this.allocateProjectRepository.deleteById(allocateProjectId);
			
		}
		else
		{
			throw new ResourceNotFoundException("AllocateProject","AllocateProjectId", allocateProjectId);
		}
	}
		
		
	
	@Override
	public AllocateProjectDTO updateAllocateProjectByID(AllocateProjectDTO allocateProject, int allocateProjectId) {
		// TODO Auto-generated method stub
		if(this.allocateProjectRepository.existsById(allocateProjectId)) 
		{
			AllocateProjectEntity allocateProjectObj = this.modelMapper.map(allocateProject,AllocateProjectEntity.class);
			AllocateProjectEntity updatedAllocateProject= this.allocateProjectRepository.save(allocateProjectObj);
			
			return this.modelMapper.map(updatedAllocateProject, AllocateProjectDTO.class);
		}
		else
		{
			throw new ResourceNotFoundException("AllocateProject","AllocateProjectId", allocateProjectId);
		}
		//return null;
		
	}
	
	@Override
	public List<AllocateProjectDTO> getAllocateProjectByProjectId(int projectId) 
	{

      
		  if(this.projectRepository.existsById(projectId))
		    {
		    	//DepartmentEntity updatedDepartment=this.departmentRepository.save(departmentObj).get();
		    	List<AllocateProjectEntity> allocateprojectList =this.allocateProjectRepository.getAllAllocateProjectByProjectId(projectId);
		    	 
		    	List<AllocateProjectDTO> allocateprojectDTOList =allocateprojectList.stream()
		    	   .map(allocateproject ->this.modelMapper.map(allocateproject, AllocateProjectDTO.class))
		    	   .collect(Collectors.toList());
		    	
		    	
		    	return allocateprojectDTOList;
		    	
		    	
		    	}
	    else
		    {
	    	throw new ResourceNotFoundException("Project","ProjectID",projectId);
		    }
		
		//return null;
	}

	@Override
	public List<AllocateProjectDTO> getAllocateProjectByEmployeeId(int employeeId) {
		
		
	if(this.employeeRepository.existsById(employeeId))
		{
		// TODO Auto-generated method stub
		List<AllocateProjectEntity> allocateprojectList =this.allocateProjectRepository.getAllAllocateProjectByEmployeeId(employeeId);   	 
    	List<AllocateProjectDTO> allocateprojectDTOList =allocateprojectList.stream()
   	   .map(allocateproject ->this.modelMapper.map(allocateproject, AllocateProjectDTO.class))
   	   .collect(Collectors.toList());
  	
  	
   	return allocateprojectDTOList;
   	
   	
   	}
   else
   {
   	throw new ResourceNotFoundException("Employee","EmployeeID",employeeId);
   }
	}


	
	

}