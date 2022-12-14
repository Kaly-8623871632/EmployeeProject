package com.boot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.boot.entity.DepartmentEntity;
import com.boot.entity.ProjectEntity;



public interface ProjectRepository  extends JpaRepository<ProjectEntity,Integer>{
}