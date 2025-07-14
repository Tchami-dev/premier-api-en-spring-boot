package com.advance.iforce.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.advance.iforce.api.model.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    // void deleteById(int id);

}