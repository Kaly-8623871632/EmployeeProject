package com.boot.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.boot.entity.AllocateProjectEntity;
import com.boot.entity.EmployeeEntity;



public interface EmployeeRepository  extends JpaRepository<EmployeeEntity,Integer>
{
	
	@Query(value="select * from employee_entity ee where ee.did=:departmentId",nativeQuery =true)
    List<EmployeeEntity> getAllEmployeeByDeaprtmentId(@Param("departmentId") int departmentId);
	
	EmployeeEntity findByEmployeeEmailAndPassword(String employeeEmail,String password);

}