package com.example.EmployeeRepository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.Employe.Employe;

public interface EmployeeRepository extends MongoRepository<Employe, String> {
    Employe findByEmployeeId(String employeeId);
}
