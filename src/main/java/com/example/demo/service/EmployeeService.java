package com.example.demo.service;

import com.example.demo.model.Customer;
import com.example.demo.model.Employee;

import java.util.List;

public interface EmployeeService {

    Employee saveEmployee(Employee employee);

    List<Employee> getAllEmployee();

    Employee getEmployeeById(Long id);

    Employee editEmployee(Long id, Employee employee);

    Boolean deleteEmployee(Long id);

}
