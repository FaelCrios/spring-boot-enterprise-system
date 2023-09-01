package com.colin.springboot.springemployeers.services;

import com.colin.springboot.springemployeers.entity.Employee;
import java.util.List;


public interface EmployeeService {

    public List<Employee> findAll();

    public Employee findById(Integer id);

    public Employee save(Employee empl);

    public void deleteById(Integer id);
}
