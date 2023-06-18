package com.example;

import com.example.domain.Company;
import com.example.domain.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class BootApplicationTest {
    @PersistenceContext
    EntityManager entityManager;

    @Test
    @Transactional
    void save_and_find() {
        // save
        Company companyA = new Company("company_A");
        entityManager.persist(companyA);

        Employee employeeA = new Employee("employee_A", companyA);
        entityManager.persist(employeeA);

        entityManager.flush();
        entityManager.clear();

        // find
        Employee foundEmployee = entityManager.find(Employee.class, employeeA.getId());

        assertThat(foundEmployee.getCompany()).isEqualTo(companyA);
    }
}