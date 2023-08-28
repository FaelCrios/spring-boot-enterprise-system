package com.colin.springboot.springemployeers.dao;

import com.colin.springboot.springemployeers.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> query = entityManager.createQuery("from Employee", Employee.class);
        return query.getResultList();
    }

    @Override
    public Employee findByID(Integer id) {
        Employee Empl = entityManager.find(Employee.class, id);
        return Empl;
    }

    //This method it works for merge and create entities, with don't match with some existing ID
    //Another entity will be created
    @Override
    public Employee save(Employee empl) {
        return entityManager.merge(empl);
    }

    @Override
    public void deleteById(Integer id) {
        Employee empl = entityManager.find(Employee.class, id);
        entityManager.remove(empl);
    }


}
