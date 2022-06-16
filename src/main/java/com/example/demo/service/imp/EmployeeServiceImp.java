package com.example.demo.service.imp;

import com.example.demo.model.Customer;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;

import java.util.List;
import java.util.Optional;

public class EmployeeServiceImp implements EmployeeService {

    private final EmployeeRepository employeeRepository;

   public EmployeeServiceImp(EmployeeRepository employeeRepository){
       this.employeeRepository = employeeRepository;
   }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        Optional<Employee> employee=employeeRepository.findById(id);

        if (employee.isPresent()){
            return employee.get();
        }else {
            throw new RuntimeException("customer not found");
        }
    }

    @Override
    public Employee editEmployee(Long id, Employee employee) {

        Employee newEmployee = employeeRepository.findById(id).
                orElseThrow(()-> new IllegalArgumentException(id+"not found"));

        newEmployee.setEmpName(employee.getEmpName());
        newEmployee.setEmpSurname(employee.getEmpSurname());
        newEmployee.setEmpTckn(employee.getEmpTckn());
        newEmployee.setEmpEmail(employee.getEmpEmail());
        newEmployee.setEmpPassword(employee.getEmpPassword());

        return employeeRepository.save(newEmployee);
    }


    @Override
    public Boolean deleteEmployee(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);

        if (employee.isPresent()){
            employeeRepository.deleteById(id);
            return true;
        }
        throw new RuntimeException("employee not deleted success");
    }
}
