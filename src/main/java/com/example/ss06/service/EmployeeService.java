package com.example.ss06.service;

import com.example.ss06.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    boolean create(Employee employee);
    Employee findById(int id);
    boolean update(Employee employee);
    boolean delete(int id);
}
