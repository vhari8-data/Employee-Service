package com.example.employeeservice;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    private List<Employee> employees = new ArrayList<>();

    public EmployeeService() {
        employees.add(new Employee(1L, "Hari", "DevOps Engineer", "Cloud"));
        employees.add(new Employee(2L, "Ravi", "Java Developer", "IT"));
        employees.add(new Employee(3L, "Anita", "QA Engineer", "Testing"));
    }

    public List<Employee> getAllEmployees() {
        return employees;
    }

    public Employee getById(Long id) {
        return employees.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public List<Employee> getByPosition(String position) {
        return employees.stream()
                .filter(e -> e.getPosition().equalsIgnoreCase(position))
                .toList();
    }
}
