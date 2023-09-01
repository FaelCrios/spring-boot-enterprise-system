package com.colin.springboot.springemployeers.services;

import com.colin.springboot.springemployeers.entity.Employee;
import com.colin.springboot.springemployeers.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository repository;


    @Override
    public List<Employee> findAll() {
        return repository.findAll();
    }

    @Override
    public Employee findById(Integer id) {
        Optional<Employee> search = repository.findById(id);
        Employee temp = null;
        if(search.isPresent()){
            temp = search.get();
        }
        else{
            throw new RuntimeException("Didn't found the Employee ID: "+id);
        }
        return temp;
    }

    @Override
    public Employee save(Employee empl) {
        return repository.save(empl);
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
