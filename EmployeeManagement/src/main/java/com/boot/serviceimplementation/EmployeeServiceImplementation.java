package com.boot.serviceimplementation;


import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.entity.EmployeeEntity;
import com.boot.exception.ResourceNotFoundException;
import com.boot.payload.EmployeeDTO;
import com.boot.repository.EmployeeRepository;
import com.boot.service.EmployeeService;





@Service
public class EmployeeServiceImplementation implements EmployeeService
{
   
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	

    @Override
	public EmployeeDTO addemployee(EmployeeDTO employee) {
		// TODO Auto-generated method stub
    	EmployeeEntity  employeeEntity = this.modelMapper.map(employee, EmployeeEntity .class);
		
    	EmployeeEntity  savedEmployeeEntity  = this.employeeRepository.save(employeeEntity );
		
		return this.modelMapper.map(savedEmployeeEntity , EmployeeDTO.class);
		
    	
	}
	@Override
	public List<EmployeeDTO> getAllemployeeList() {
		// TODO Auto-generated method stub
		List<EmployeeEntity > employeeList =this.employeeRepository.findAll();
		List<EmployeeDTO>  employeeListDto = employeeList.stream().map(employee->this.modelMapper.map(employee, EmployeeDTO.class))
				.collect(Collectors.toList());
		return employeeListDto;
		
		
	}
	@Override
	public EmployeeDTO getEmployeeById(int employeeId) {
		// TODO Auto-generated method stub
		
		EmployeeEntity employeeObj = this.employeeRepository
				.findById(employeeId).orElseThrow(()-> new ResourceNotFoundException("employee","employeeId",employeeId));
				return this.modelMapper.map(employeeObj, EmployeeDTO.class);
		
	}
	@Override
	public void deleteEmployeeById(int employeeId) {
		// TODO Auto-generated method stub
		if(this.employeeRepository.existsById(employeeId)) 
		{
			this.employeeRepository.deleteById(employeeId);
			
		}
		else
		{
			throw new ResourceNotFoundException("Employee","EmployeeId", employeeId);
		}
	}
		
		
	
	@Override
	public EmployeeDTO updateEmployeeByID(EmployeeDTO employee, int employeeId) {
		// TODO Auto-generated method stub
		if(this.employeeRepository.existsById(employeeId)) 
		{
			EmployeeEntity employeeObj = this.modelMapper.map(employee,EmployeeEntity.class);
			EmployeeEntity updatedEmployee= this.employeeRepository.save(employeeObj);
			
			return this.modelMapper.map(updatedEmployee, EmployeeDTO.class);
		}
		else
		{
			throw new ResourceNotFoundException("Employee","EmployeeId", employeeId);
		}
		//return null;
		
	}
	
	@Override
	public EmployeeDTO checkLogin(String employeeEmail,String password) {
		
		 EmployeeEntity employeeObj= this.employeeRepository.findByEmployeeEmailAndPassword(employeeEmail, password);
		
		 return this.modelMapper.map(employeeObj, EmployeeDTO.class);
	}
	@Override
	public List<EmployeeDTO> getAllemployeeBydepartmentId(int departmentId) {
		
		
		
			List<EmployeeEntity > employeeList =this.employeeRepository.getAllEmployeeByDeaprtmentId(departmentId);
			List<EmployeeDTO>  employeeListDto = employeeList.stream().map(employee->this.modelMapper.map(employee, EmployeeDTO.class))
					.collect(Collectors.toList());
			return employeeListDto;
	
//		else
//		{
//			throw new ResourceNotFoundException("Department","DepartmentId", departmentId);
//		}
//
	
	
	
	
	}
}
//	public EmployeeEntity  EmployeeDTOToEmployeeEntity (EmployeeDTO employeeDTO)
//    {
//    	EmployeeEntity  employee = new EmployeeEntity ();
//    	employee.setEmployeeId(employeeDTO.getEmployeeId());
//    	employee.setEmployeeSalary(employeeDTO.getEmployeeSalary());
//    	employee.setEmployeeContactNumber(employeeDTO.getEmployeeContactNumber());
//    	employee.setEmployeeName(employeeDTO.getEmployeeName());
//    	employee.setEmployeeAddress(employeeDTO.getEmployeeAddress());
//    	employee.setEmployeeGender(employeeDTO.getEmployeeGender());
//    	employee.setEmployeeDOB(employeeDTO.getEmployeeDOB());
//    	employee.setEmployeeDateOfJoin(employeeDTO.getEmployeeDateOfJoin());
//    	
//    	
//    	
//		return employee;	
//    	
//    }
//    public EmployeeDTO employeeEntityToEmployeeDTO(EmployeeEntity  employeeEntity)
//    {
//    	EmployeeDTO employee1 =new EmployeeDTO();
//    	employee1.setEmployeeId(employeeEntity.getEmployeeId());
//    	employee1.setEmployeeSalary(employeeEntity.getEmployeeSalary());
//    	employee1.setEmployeeContactNo(employeeEntity.getEmployeeContactNo());
//    	employee1.setEmployeeName(employeeEntity.getEmployeeName());
//    	employee1.setEmployeeAddress(employeeEntity.getEmployeeAddress());
//    	employee1.setEmployeeGender(employeeEntity.getEmployeeGender());
//    	employee1.setEmployeeDOB(employeeEntity.getEmployeeDOB());
//    	employee1.setEmployeeDateOfJoin(employeeEntity.getEmployeeDateOfJoin());
//    	
//    	
//		return employee1;
//    	
//    }  

