package com.boot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.boot.entity.EnrolledCourseEntity;
import com.boot.entity.StudentEntity;


public interface EnrolledCourseRepository extends JpaRepository<EnrolledCourseEntity,Integer>
{

	
  List<EnrolledCourseEntity> findByStudent(StudentEntity student);
 
 
     @Query(value="select * from enrolled_courses_entity ec where ec.sid=:studentId",nativeQuery =true)
     List<EnrolledCourseEntity> getAllEnrolledCourseByStudentId(@Param("studentId") int studentId);
	
     @Query(value="select * from enrolled_courses_entity ec where ec.cid=:courseId",nativeQuery =true)
     List<EnrolledCourseEntity> getAllEnrolledCourseByCourseId(@Param("courseId") int courseId);
	
}