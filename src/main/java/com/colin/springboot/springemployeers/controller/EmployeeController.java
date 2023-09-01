package com.colin.springboot.springemployeers.controller;
import java.util.List;
import java.util.Optional;

import com.colin.springboot.springemployeers.entity.Employee;
import com.colin.springboot.springemployeers.repository.EmployeeRepository;
import com.colin.springboot.springemployeers.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @GetMapping
    public List<Employee> findAll(){
        return service.findAll();
    };

    @GetMapping("/{id}")
    public Employee getById(@PathVariable Integer id){
        Employee empl = service.findById(id);
        if(empl == null){
            throw new RuntimeException("Didn't found employee ID: "+id);
        }
        else {
            return empl;
        }
    };

    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        employee.setId(null);
        return service.save(employee);

    }

     @PutMapping
    public Employee updateEmployee(@RequestBody Employee employee){
         return service.save(employee);
     }

     @DeleteMapping("/{id}")
    public Employee deleteEmployee(@PathVariable Integer id){
       Employee temp = service.findById(id);
       if(temp == null){
           throw new RuntimeException("Employee id not found"+id);
       }
       else {
           service.deleteById(id);
           return temp;
       }
     };




}
