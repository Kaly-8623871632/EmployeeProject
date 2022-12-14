package com.boot.entity;

import java.util.ArrayList;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="course")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CourseEntity {

            @Id
            @GeneratedValue(strategy=GenerationType.AUTO)
            private int courseId;
            
            @NotEmpty( message="Course name can not be empty")
   	        @Column(nullable=false)
   	        @Size(min=2,max=10,message="course name must be minimum 2 characters and maximum 10")
   	     
            private String courseName;
            
            @NotEmpty( message="CourseDescription name can not be empty")
   	       
           // @Min(message="Minimum  character should be 2",value=2)
   	        //@Max(message="Maximum character should be 100",value=100)*/
            @Column(nullable=false)
            
   	        private String courseDescription;
           
            @NotEmpty( message="CourseDuration can not be empty")
            @Size(min=2,max=10,message="courseDuration name must be minimum 2 characters and maximum 10")
      	    @Column(nullable = false)
            
            private String courseDuration;
            
            @NotNull( message="CourseFee  can not be empty")
            @Min(message="Minimum fee should be 500",value=500)
   	        @Max(message="Maximum fee should be 1000",value=1000)
   	        @Column(nullable = false)
            
            private int courseFee;
         
            @JsonIgnore
            @OneToMany(mappedBy ="course1" ,cascade = CascadeType.ALL)
            private List<EnrolledCourseEntity> courseList=new ArrayList<>();
            
}