package com.example.demo.controller;


import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    private final EmployeeService employeeService;


    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @PostMapping("/save")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
        Employee result = employeeService.saveEmployee(employee);
        return ResponseEntity.ok(result);
    }


    @GetMapping("/getAll")
    public List<Employee> getAllEmployee(){
        List<Employee> list = employeeService.getAllEmployee();
        return  list;
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Employee> getById(@PathVariable("id") Long id){
        Employee employee = employeeService.getEmployeeById(id);
        return  ResponseEntity.ok(employee);
    }


    @PutMapping("/edit/{id}")
    public ResponseEntity<Employee> editEmployee(@PathVariable Long id, @RequestBody Employee employee){
        Employee result = employeeService.editEmployee(id, employee);
        return ResponseEntity.ok(result);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteEmployee(@PathVariable("id") Long id){
        Boolean status = employeeService.deleteEmployee(id);
        return ResponseEntity.ok(status);
    }

}
