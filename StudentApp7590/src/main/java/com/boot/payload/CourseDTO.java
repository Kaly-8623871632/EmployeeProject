package com.boot.payload;


import java.util.ArrayList;
import java.util.List;

import com.boot.controller.EnrolledCourseController;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class CourseDTO
{
	       private int courseId;
     
           private String courseName;
     
           private String courseDescription;
     
           private String courseDuration;
     
           private int courseFee;

           
           @JsonIgnore
       private List<EnrolledCourseController> courseList=new ArrayList<>();

}