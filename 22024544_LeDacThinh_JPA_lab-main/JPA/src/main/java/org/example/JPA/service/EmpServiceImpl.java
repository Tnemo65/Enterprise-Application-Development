package org.example.JPA.service;
import java.util.ArrayList;
import java.util.Optional;

import org.example.JPA.modal.Employee;
import org.example.JPA.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public ArrayList<Employee> findAllEmployee() {
        return (ArrayList<Employee>) employeeRepository.findAll();
    }

    @Override
    public Employee findAllEmployeeByID(long id) {
        Optional<Employee> opt = employeeRepository.findById(id);
        return opt.orElse(null);
    }

    @Override
    public void addEmployee() {
        employeeRepository.save(new Employee("John Doe", "New York"));
    }

    @Override
    public void deleteAllData() {
        employeeRepository.deleteAll();
    }
}
