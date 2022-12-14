package com.boot.serviceimplementation;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.entity.DepartmentEntity;
import com.boot.entity.EmployeeEntity;
import com.boot.exception.ResourceNotFoundException;
import com.boot.payload.DepartmentDTO;
import com.boot.payload.EmployeeDTO;
import com.boot.repository.DepartmentRepository;
import com.boot.service.DepartmentService;


@Service
public class DepartmentServiceImplementation implements DepartmentService
{
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public  DepartmentDTO addDepartment(DepartmentDTO department) 
	{
		DepartmentEntity departmentEntity = this.modelMapper.map(department, DepartmentEntity.class);
		DepartmentEntity savedDepartment =this.departmentRepository.save(departmentEntity);
	   return this.modelMapper.map(savedDepartment, DepartmentDTO.class);
	
	}

	@Override
	public List<DepartmentDTO> getAllDepartmentList() {
		List<DepartmentEntity> departmentList =this.departmentRepository.findAll();
		List<DepartmentDTO>  departmentListDto = departmentList.stream()
				                                    .map(department->this.modelMapper.map(department, DepartmentDTO.class)) 
				                                    .collect(Collectors.toList());

		return departmentListDto;
        //return null;
	}

	@Override
	public DepartmentDTO getDepartmentById(int departmentId) {
		DepartmentEntity departmentObj=this.departmentRepository.
                findById(departmentId).orElseThrow(()-> new ResourceNotFoundException("department","departmentID", departmentId));	          
      
           return this.modelMapper.map(departmentObj,DepartmentDTO.class);

		//return null;
	}

	@Override
	public void deleteDepartmentById(int departmentId)
	{
		if(this.departmentRepository.existsById(departmentId))
		{
			this.departmentRepository.deleteById(departmentId);
		}
		else
		{
			throw new ResourceNotFoundException("department","departmentID", departmentId);	
		}
	
	}

	@Override
	public DepartmentDTO updateDepartmentById(DepartmentDTO department, int departmentId) {
		 if(this.departmentRepository.existsById(departmentId))
		    {
			 DepartmentEntity departmentObj= this.modelMapper.map(department, DepartmentEntity.class);
			 DepartmentEntity updateddepartment=this.departmentRepository.save(departmentObj);
		    	
		    	return this.modelMapper.map(updateddepartment, DepartmentDTO.class);
		    	}
		    else
		    {
		    	throw new ResourceNotFoundException("Department","DepartmentID",departmentId);
		    }
			}

//	@Override
//	public List<DepartmentDTO> getAlldepartmentByprojectId(int projectId) {
//		List<DepartmentEntity> departmentList =this.departmentRepository.getAllDepartmentByProjectId(projectId);
//		List<DepartmentDTO>  departmentListDto = departmentList.stream().map(department->this.modelMapper.map(department, DepartmentDTO.class))
//				.collect(Collectors.toList());
//		return departmentListDto;
//	}

	    
	

}