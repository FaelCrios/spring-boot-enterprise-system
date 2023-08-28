package com.colin.springboot.springemployeers.services;

import com.colin.springboot.springemployeers.dao.EmployeeDAO;
import com.colin.springboot.springemployeers.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeDAO employeeDAO;

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public Employee findById(Integer id) {
        return employeeDAO.findByID(id);
    }

    @Transactional
    @Override
    public Employee save(Employee empl) {
        return employeeDAO.save(empl);
    }

    @Transactional
    @Override
    public void deleteById(Integer id) {
        employeeDAO.deleteById(id);

    }
}
