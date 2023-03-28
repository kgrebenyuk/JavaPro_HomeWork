package com.example.demowithtests.service;

import com.example.demowithtests.domain.Employee;
import com.example.demowithtests.util.UserIsNotExistException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public interface Service {

    Employee create(Employee employee);

    List<Employee> getAll();

    Employee getById(String id);

    Employee updateById(Integer id, Employee plane) throws UserIsNotExistException;

    void removeById(Integer id);

    void removeAll();

    List<Employee> sendEmailByCountry(String country, String text);

    List<Employee> sendEmailByCity(String city, String text);

    List<Employee> sendEmailOldFoto( String text);

    Employee createrEmployee(String name, String country, String email);

    void updaterByCountryFully(String countries);

    List<Employee> processor();

//////////////////////
    String randomCountry(String countriesList);

    void fillDB(int numberOfTimes, String countriesString);

    void updateAllByCountry(String newCountry);

    void updateAllByCountrySmart(String oldCountry, String newCountry);

 //   List<Employee> metricsByCountry(String fromCountry, String toCountry);
    void metricsByCountry(String fromCountry, String toCountry, String text);


}