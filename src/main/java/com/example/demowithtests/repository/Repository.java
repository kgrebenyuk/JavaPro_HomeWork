package com.example.demowithtests.repository;

import com.example.demowithtests.domain.Employee;
import com.example.demowithtests.domain.Foto;
import lombok.Data;
import org.hibernate.engine.spi.SessionDelegatorBaseImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.metamodel.Metamodel;

//import java.sql.Date;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@org.springframework.stereotype.Repository
//@Component
public interface Repository extends JpaRepository<Employee, Integer> {


    Employee findByName(String name);

    Employee findEmployeeByEmail(String email);

    //Boolean existsAny();

    List<Employee> findEmployeeByIsDeletedIsTrue();


    //List<Employee> findEmployeeByIsDeletedNull();

    @Query(value = " select e from Employee e where e.country=:country")
    List<Employee> findEmployeeByCountry(String country);

    @Query(value = "select e from Employee e join e.addresses a where a.city=:city")
    List<Employee> findEmployeeByAddresses(String city);

    static void saveAllSmart(List<Employee> employees) {};
    List<Employee> findEmployeeByIsDeletedNull();

   //get all users with Foto more than 1 year old
   @Query(value = "select e from Employee e join e.fotos a where a.creationTime < :data")
  // @Query(value = "select * from foto where creationTime < :data", nativeQuery = true)
//   @Query(value = "select fotos.creation_time from fotos where fotos.creation_time < :data", nativeQuery = true)
    List<Employee> findEmployeeOldFoto(Date data);
   // List<Date> findEmployeeOldFoto(Date data);


}