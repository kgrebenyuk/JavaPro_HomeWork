package com.example.demowithtests.repository;

import com.example.demowithtests.domain.Employee;
import com.example.demowithtests.domain.Passport;
import com.example.demowithtests.domain.Workplace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface WorkplaceRepository extends JpaRepository<Workplace, Integer> {

//    @Query(value = "select * from passports join registrations on registrations.passport_id=passports.id where registrations.country=:country", nativeQuery = true)
//    List<Passport> findPassportsWithCountry(String country);

    @Query(value = "select Count(*) from users_workplaces where users_workplaces.workplaces_id = :workplaceid", nativeQuery = true)
    Integer findNumberEmployeesInWorkplace(Integer workplaceid);


}