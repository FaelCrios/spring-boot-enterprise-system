package com.colin.springboot.springemployeers.dao;

import com.colin.springboot.springemployeers.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();

    Employee findByID(Integer id);


    Employee save(Employee empl);

    void deleteById(Integer id);
}
