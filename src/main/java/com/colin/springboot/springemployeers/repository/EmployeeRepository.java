package com.colin.springboot.springemployeers.repository;

import com.colin.springboot.springemployeers.entity.Employee;
import com.colin.springboot.springemployeers.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository <Employee, Integer> {


}
