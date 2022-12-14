package com.boot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.boot.entity.DepartmentEntity;




public interface DepartmentRepository extends JpaRepository<DepartmentEntity,Integer>
{
//	@Query(value="select * from department dept where dept.pid=:projectId",nativeQuery =true)
//    List<DepartmentEntity> getAllDepartmentByProjectId(@Param("projectId") int projectId);

}