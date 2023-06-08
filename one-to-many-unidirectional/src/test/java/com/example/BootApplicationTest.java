package com.example;

import com.example.domain.Company;
import com.example.domain.Employee;
import com.example.infrastructure.CompanyRepository;
import com.example.infrastructure.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BootApplicationTest {
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    void save() {
        Employee employeeA = new Employee("employeeA");
        Company companyA = new Company("companyA");
        companyA.addEmployee(employeeA);

        employeeRepository.save(employeeA);
        companyRepository.save(companyA);
    }
}