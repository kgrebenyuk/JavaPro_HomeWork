package com.example.demowithtests.service.Employee;

import com.example.demowithtests.domain.Employee;
import com.example.demowithtests.domain.Passport;
import com.example.demowithtests.util.MyGlobalExceptionHandler;
import com.example.demowithtests.util.UserIsNotExistException;

import java.util.List;

public interface EmployeeService {

    Employee create(Employee employee);

    List<Employee> getAll();

    Employee getById(Integer id);

    Employee updateById(Integer id, Employee plane) throws UserIsNotExistException;

    void removeById(Integer id);

    void removeAll();

    List<Employee> sendEmailByCountry(String country, String text);

    List<Employee> sendEmailByCity(String city, String text);

    List<Employee> sendEmailOldFoto(String text);

 //   Employee createrEmployee(String name, String country, String email);

    void updaterByCountryFully(String countries);

    List<Employee> processor();

    String randomCountry(String countriesList);

    void fillDB(int numberOfTimes, String countriesString);

    void updateAllByCountry(String newCountry);

    void updateAllByCountrySmart(String oldCountry, String newCountry);

    List<String> metricsByCountry(String fromCountry, String toCountry, String text);

    Employee addPassport(Integer employeeId, Integer passportId);

    Employee addPassport(Integer employeeId);

    Employee addWorkplace(Integer employeeId, Integer workplaceId, Integer maxEmployees) throws MyGlobalExceptionHandler;


}