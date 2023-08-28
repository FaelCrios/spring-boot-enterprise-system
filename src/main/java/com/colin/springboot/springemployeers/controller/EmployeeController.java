package com.colin.springboot.springemployeers.controller;
import java.util.List;
import com.colin.springboot.springemployeers.dao.EmployeeDAO;
import com.colin.springboot.springemployeers.entity.Employee;
import com.colin.springboot.springemployeers.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @GetMapping("/{id}")
    public Employee findById(@PathVariable Integer id){

            return employeeService.findById(id);
    }
}
