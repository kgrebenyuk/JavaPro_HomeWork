package com.example.demowithtests.repository;

import com.example.demowithtests.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

//import java.sql.Date;
import java.util.Date;
import java.util.List;

//@org.springframework.stereotype.Repository
@Repository
//@Component
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    Employee findByName(String name);

    Employee findEmployeeByEmail(String email);

    List<Employee> findEmployeeByIsDeletedIsTrue();


    @Query(value = " select e from Employee e where e.country=:country")
    List<Employee> findEmployeeByCountry(String country);

    @Query(value = "select e from Employee e join e.addresses a where a.city=:city")
    List<Employee> findEmployeeByAddresses(String city);

    static void saveAllSmart(List<Employee> employees) {
    }

    ;

    List<Employee> findEmployeeByIsDeletedNull();

    @Query(value = "select e from Employee e join e.fotos a where a.creationTime < :data")
    List<Employee> findEmployeeOldFoto(Date data);

    @Query(value = "select users.email from users join addresses on addresses.employee_id = users.id\n" +
            "where (users.country = 'Ukraine'and addresses.country = 'Poland' and address_has_active = 'true')", nativeQuery = true)
    List<String> findEmployeeChangedCountry(String fromCountry, String toCountry);

}