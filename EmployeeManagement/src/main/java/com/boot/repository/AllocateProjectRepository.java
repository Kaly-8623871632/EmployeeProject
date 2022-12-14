package com.boot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.boot.entity.AllocateProjectEntity;
import com.boot.entity.ProjectEntity;


public interface AllocateProjectRepository extends JpaRepository<AllocateProjectEntity,Integer>
{

	
	 @Query(value="select * from allocate_project_entity ape where ape.pid=:projectId",nativeQuery =true)
     List<AllocateProjectEntity> getAllAllocateProjectByProjectId(@Param("projectId") int projectId);
	
     @Query(value="select * from allocate_project_entity ape where ape.eid=:employeeId",nativeQuery =true)
     List<AllocateProjectEntity> getAllAllocateProjectByEmployeeId(@Param("employeeId") int employeeId);
	
	

	
	

}