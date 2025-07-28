package org.example.JPA.controller;
import java.util.ArrayList;

import org.example.JPA.modal.Employee;
import org.example.JPA.service.EmpServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmpController {

    @Autowired
    EmpServiceImpl empServiceImpl;
    @PostMapping("/")
    public void add() {
        empServiceImpl.addEmployee();
    }

    @GetMapping("/findall")
    public ArrayList<Employee> getAllEmployee() {
        return empServiceImpl.findAllEmployee();
    }

    @GetMapping("/findbyid/{id}")
    public Employee getEmployeeUsingId(@PathVariable long id) {
        return empServiceImpl.findAllEmployeeByID(id);
    }

    @DeleteMapping("/delete")
    public void delete() {
        empServiceImpl.deleteAllData();
    }
}
