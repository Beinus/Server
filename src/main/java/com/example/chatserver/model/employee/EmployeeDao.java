package com.example.chatserver.model.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeDao {
    @Autowired
    private EmployeeRepository repository;

    public Employee save(Employee employee) {
        return repository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        Streamable.of(repository.findAll())
                .forEach(employees::add);
        return employees;
    }
    // Or take a look at Guava dependency for making this function
    public void delete(Employee employee) {
        repository.delete(employee);
    }
}
