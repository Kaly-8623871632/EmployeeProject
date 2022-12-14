package com.boot.service;


import java.util.List;

import com.boot.payload.EmployeeDTO;


public interface EmployeeService
{
  public EmployeeDTO addemployee(EmployeeDTO employee);
  
  public List<EmployeeDTO> getAllemployeeList();
  
  public EmployeeDTO getEmployeeById(int employeeId);
  
  public void deleteEmployeeById(int employeeId);
  
  public EmployeeDTO updateEmployeeByID(EmployeeDTO employee, int employeeId);

  public EmployeeDTO checkLogin(String employeeEmail,String password);
  
  public List<EmployeeDTO> getAllemployeeBydepartmentId(int departmentId);
}