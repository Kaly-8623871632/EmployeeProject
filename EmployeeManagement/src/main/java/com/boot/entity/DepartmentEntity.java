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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@Entity
@Table(name="department")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentEntity {
	
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	 private int departmentId;
	 
	
	 @NotEmpty( message="Department name can not be empty")
     @Column(nullable=false)
     @Size(min=2,max=10,message="Department name must be minimum 2 characters and maximum 10")
	 private String departmentName;

	 @JsonIgnore
    @OneToMany(mappedBy = "department",cascade = CascadeType.ALL)	
     List<EmployeeEntity> employeeList = new ArrayList();

    @JsonIgnore
    @OneToMany(mappedBy="department",cascade=CascadeType.ALL)
    List<ProjectEntity> projectList=new ArrayList();
}