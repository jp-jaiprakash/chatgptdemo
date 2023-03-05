package com.example.chatgptdemo.services;

import com.example.chatgptdemo.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

List<Employee> employees = new ArrayList<>();

//    public Employee getEmployeeById(Long id) {
//        return employeeRepository.findById(id).orElse(null);
//    }

    public List<Employee> getAllEmployees() {
        return employees;
    }

    public Employee createEmployee(Employee employee) {
        employees.add(employee);
        return employee;
    }

//    public Employee updateEmployee(Long id, Employee employee) {
//        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
//        if (optionalEmployee.isPresent()) {
//            employee.setId(id);
//            return employeeRepository.save(employee);
//        } else {
//            return null;
//        }
//    }
//
//    public boolean deleteEmployee(Long id) {
//        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
//        if (optionalEmployee.isPresent()) {
//            employeeRepository.deleteById(id);
//            return true;
//        } else {
//            return false;
//        }
//    }

}
