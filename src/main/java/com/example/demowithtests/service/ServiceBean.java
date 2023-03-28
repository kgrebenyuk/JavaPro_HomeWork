package com.example.demowithtests.service;

import com.example.demowithtests.domain.Employee;
import com.example.demowithtests.domain.Foto;
import com.example.demowithtests.repository.Repository;
import com.example.demowithtests.util.*;
import lombok.Data;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.event.Level;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

//import static java.lang.System.Logger.Level.DEBUG;
//import static org.apache.logging.log4j.util.LowLevelLogUtil.log;


//@AllArgsConstructor
@Slf4j
@org.springframework.stereotype.Service
public class ServiceBean implements Service {
    private final Repository repository;

    //  private static final Logger log = Logger.getLogger(ServiceBean.class.getName());

    public ServiceBean(Repository repository) {
        this.repository = repository;
    }


    // @SneakyThrows
    @Override
    public Employee create(Employee employee) {
        if (employee.getEmail() == null) throw new EmailAbsentException();
//      if (repository.findEmployeeByEmail(employee.getEmail()) != null) throw new EmailDoubledException();

        return repository.save(employee);
    }

    @Override
    public List<Employee> getAll() {
        if (repository.findAll().size() > 0) {
            if (repository.findAll().size() == repository.findEmployeeByIsDeletedIsTrue().size()) {
                throw new ListWasDeletedException();
            }
            return repository.findAll();
        }
        throw new ListHasNoAnyElementsException();

    }

    @Override
    public Employee getById(String id) {
        // log.debug("----> getById() - start: id = {}", id);

        try {
            Integer employeeId = Integer.parseInt(id);
            Employee employee = repository.findById(employeeId)
                    .orElseThrow(IdIsNotExistException::new);
            if (employee.getIsDeleted()) {
                throw new ResourceWasDeletedException();
            }

            //  log.debug("----> getById() -try  employee = {}", employee);

            return employee;
        } catch (NumberFormatException exception) {

            //  log.debug("----> getById() - end: employee = {}", exception);

            throw new WrongDataException();

        }

    }

    //@SneakyThrows
    @Override
    public Employee updateById(Integer id, Employee employee) throws UserIsNotExistException {
        return repository.findById(id)
                .map(entity -> {
                    entity.setName(employee.getName());
                    entity.setEmail(employee.getEmail());
                    entity.setCountry(employee.getCountry());
                    return repository.save(entity);
                })
                .orElseThrow(UserIsNotExistException::new);
    }

    @Override
    public void removeById(Integer id) {
        Employee employee = repository.findById(id)
                .orElseThrow(IdIsNotExistException::new);
        if (employee.getDeleted()) throw new UserAlreadyDeletedException();
        employee.setIsDeleted(true);
        repository.save(employee);
    }

    @Override
    public void removeAll() {

        if (repository.findAll().size() > 0) {
            if (repository.findAll().size() == repository.findEmployeeByIsDeletedIsTrue().size()) {
                throw new ListWasDeletedException();
            }
            List<Employee> base = repository.findAll();
            for (Employee employee : base) {
                employee.setIsDeleted(true);
            }
        }
        throw new ListHasNoAnyElementsException();


    }


    public void mailSender(List<String> emails, String text) {
        log.info("---->>  Emails sent successfully ", emails);
    }

    @Override
    public List<Employee> sendEmailByCountry(String country, String text) {
        List<Employee> employees = repository.findEmployeeByCountry(country);
        mailSender(getterEmailsOfEmployees(employees), text);
        return employees;
    }

    public List<Employee> sendEmailByCity(String citiesString, String text) {
        String[] citiesArray = citiesString.split(",");
        List<String> citiesList = Arrays.asList(citiesArray);
        List<Employee> employees = new ArrayList<>();
        for (String city : citiesList) {
            List<Employee> employeesByCity = repository.findEmployeeByAddresses(city);
            employees.addAll(employeesByCity);
        }
        mailSender(getterEmailsOfEmployees(employees), text);

        return employees;
    }



/*    @Override
    public void fillingDataBase(String quantityString) {
        int quantity = Integer.parseInt(quantityString);
        for (int i = 0; i <= quantity; i++) {
            repository.save(createrEmployee("name", "country", "email"));
        }
    }
  */

    //   @Override
//    public void fillDB(int numberOfTimes) {
//        for (int i = 0; i <= numberOfTimes; i++) {
//            Employee employee = new Employee("name", "Ukraine", "email.gmail.com");
//            // repository.save(createrEmployee("name", "country", "email"));
//            create(employee);
//        }
//    }
//


    @Override
    public void updaterByCountryFully(String countries) {
        List<Employee> employees = repository.findAll();
        for (Employee employee : employees) {
            employee.setCountry(randomCountry(countries));
            repository.save(employee);
        }
    }

//    @Override
//    @Transactional
//    public void updaterByCountrySmart(String countries) {
//        List<Employee> employees = repository.findAll();
//        for (Employee employee : employees) {
//            String newCountry = randomCountry(countries);
//            if (!employee.getCountry().equals(newCountry)) {
//                employee.setCountry(newCountry);
//                repository.save(employee);
//            }
//        }
//    }

    @Override
    public List<Employee> processor() {
        //log.info("replace null  - start");
        List<Employee> replaceNull = repository.findEmployeeByIsDeletedNull();
        //log.info("replace null after replace: " + replaceNull);
        for (Employee emp : replaceNull) {
            emp.setIsDeleted(Boolean.FALSE);
        }
        //log.info("replaceNull = {} ", replaceNull);
        //log.info("replace null  - end:");
        return repository.saveAll(replaceNull);
    }


    private static List<String> getterEmailsOfEmployees(List<Employee> employees) {
        List<String> emails = new ArrayList<>();
        for (Employee employee : employees) {
            emails.add(employee.getEmail());
        }
        return emails;
    }

    @Override
    public Employee createrEmployee(String name, String country, String email) {
        return new Employee(name, country, email);
    }


////////////////////////////////////

    @Override
    public String randomCountry(String countriesList) {
        List<String> countries = List.of(countriesList.split(","));
        int randomIndex = (int) (Math.random() * countries.size());
        return countries.get(randomIndex);
        //  return countriesList;
    }

    @Override
    public void fillDB(int numberOfTimes, String countriesList) {
        for (int i = 0; i <= numberOfTimes; i++) {
            Employee employee = new Employee("name", randomCountry(countriesList), "email.gmail.com");
            repository.save(employee);
        }
    }

    @Override
    @Transactional
    public void updateAllByCountry(String newCountry) {
        List<Employee> employees = repository.findAll();
        for (Employee employee : employees)
            employee.setCountry(newCountry);
        repository.saveAll(employees);

    }

    @Override
    @Transactional
    public void updateAllByCountrySmart(String oldCountry, String newCountry) {
        List<Employee> employees = repository.findAll();
        for (Employee employee : employees)
            if (employee.getCountry().equals(oldCountry)) {
                employee.setCountry(newCountry);
                repository.save(employee);
            }
    }

    @Override
    public List<Employee> sendEmailOldFoto(String text) {
        Date data = Date.from(Instant.now());
        data.setYear(data.getYear() - 1);

        List<Employee> employees = repository.findEmployeeOldFoto(data);
        mailSender(getterEmailsOfEmployees(employees), text);

        log.info(" --->> List of employees with old foto: ", employees);

        return employees;
    }

}
