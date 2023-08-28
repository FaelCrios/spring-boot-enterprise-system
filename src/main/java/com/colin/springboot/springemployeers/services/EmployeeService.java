package com.colin.springboot.springemployeers.services;
import java.util.List;
import com.colin.springboot.springemployeers.entity.Employee;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(Integer id);

    Employee save(Employee empl);

    void deleteById(Integer id);
}

