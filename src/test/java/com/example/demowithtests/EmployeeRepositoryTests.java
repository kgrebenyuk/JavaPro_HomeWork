package com.example.demowithtests;

//import com.example.demowithtests.domain.employee.Employee;
import com.example.demowithtests.domain.Employee;
import com.example.demowithtests.repository.EmployeeRepository;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EmployeeRepositoryTests {

    @Autowired
    private EmployeeRepository employeeRepository;

    Employee employee = Employee.builder()
            .name("Mark")
            .country("England")
            .email("123@gmail.com")
            .isDeleted(false)
            .build();

    Employee employee2 = Employee.builder()
            .name("Mark2")
            .country("England2")
            .email("2_123@gmail.com")
            .isDeleted(false)
            .build();

    @Test
    @Order(1)
    @Rollback(value = false)
    public void saveEmployeeTest() {


        employeeRepository.save(employee);
        employeeRepository.save(employee2);

        Assertions.assertThat(employee.getId()).isGreaterThan(0);
        Assertions.assertThat(employee.getName().equals("Mark"));
        Assertions.assertThat(employee.getId()).isNotNull();
    }

    @Test
    @Order(2)
    public void getEmployeeTest() {

        Employee employee = employeeRepository.findById(1).orElseThrow();

        Assertions.assertThat(employee.getDeleted()).isEqualTo(false);
        Assertions.assertThat(employee.getFotos()).isEmpty();
        Assertions.assertThat(employee.getEmail()).isNotEmpty();
        Assertions.assertThat(employee.getId()).isEqualTo(1);

        employee = employeeRepository.findById(2).orElseThrow();
        Assertions.assertThat(employee.getDeleted()).isEqualTo(false);
        Assertions.assertThat(employee.getEmail()).isEqualTo("2_123@gmail.com");
    }

    @Test
    @Order(3)
    public void getListOfEmployeeTest() {

        List<Employee> employeesList = employeeRepository.findAll();

        Assertions.assertThat(employeesList.size()).isGreaterThan(0);
        Assertions.assertThat(employeesList.size()).isEqualTo(2);

    }

    @Test
    @Order(4)
    @Rollback(value = false)
    public void updateEmployeeTest() {

        Employee employee = employeeRepository.findById(1).get();
        employee.setName("Martin");
        Employee employeeUpdated = employeeRepository.save(employee);
        Assertions.assertThat(employeeUpdated.getName()).isEqualTo("Martin");

        Employee employee2 = employeeRepository.findById(2).get();
        employee.setEmail("email@gmail.com");
        Employee employeeUpdated2 = employeeRepository.save(employee);
        Assertions.assertThat(employeeUpdated.getEmail()).isEqualTo("email@gmail.com");

    }

    @Test
    @Order(5)
    @Rollback(value = false)
    public void deleteEmployeeTest() {

        Employee employee = employeeRepository.findById(1).get();

        employeeRepository.delete(employee);

        Employee employee1 = null;

        Optional<Employee> optionalAuthor = Optional.ofNullable(employeeRepository.findByName("Martin"));
       if (optionalAuthor.isPresent()) {
            employee1 = optionalAuthor.get();
        }

        Assertions.assertThat(employee1).isNull();
    }



}
