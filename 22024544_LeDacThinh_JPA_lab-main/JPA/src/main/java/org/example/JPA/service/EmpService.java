package org.example.JPA.service;
import java.util.ArrayList;

import org.example.JPA.modal.Employee;

public interface EmpService {
    ArrayList<Employee> findAllEmployee();
    Employee findAllEmployeeByID(long id);
    void addEmployee();
    void deleteAllData();
}
