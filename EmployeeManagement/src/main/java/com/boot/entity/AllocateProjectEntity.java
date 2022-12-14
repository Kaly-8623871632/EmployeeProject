package com.boot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Builder
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AllocateProjectEntity 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private int allocateProjectId;
	
	@NotEmpty(message="Project status can not be empty")
	@Column(nullable = false)
	@Size(min=1,max=10,message ="Project status must be minimum 1 charachters and maximum 10")
	private String projectStatus;

  
	@ManyToOne
	@JoinColumn(name = "eid")
	private EmployeeEntity employee;
	
	@ManyToOne
	@JoinColumn(name = "pid")
	private ProjectEntity project;
	
}