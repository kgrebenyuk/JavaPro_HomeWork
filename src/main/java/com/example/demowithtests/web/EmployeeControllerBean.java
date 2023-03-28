package com.example.demowithtests.web;

import com.example.demowithtests.domain.Employee;
import com.example.demowithtests.dto.EmployeeDto;
import com.example.demowithtests.dto.EmployeeReadDto;
import com.example.demowithtests.service.Service;
//import com.example.demowithtests.service.ServiceBean;
//import com.example.demowithtests.util.UserIsNotExistException;
import com.example.demowithtests.util.config.Mapper;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
//import java.util.logging.Logger;

@Slf4j
@RestController
//@AllArgsConstructor
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Employee", description = "Employee API")
public class EmployeeControllerBean implements EmployeeController {

    private final Service service;
    private final Mapper mapper;

    //   private static final Logger log = Logger.getLogger(ServiceBean.class.getName());

    public EmployeeControllerBean(Service service, Mapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    //Операция сохранения юзера в базу данных
    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    @Override
    //   public EmployeeDto saveEmployee(@RequestBody EmployeeDto employeeDto) {
    public EmployeeReadDto saveEmployee(@RequestBody EmployeeDto employeeDto) {
        log.info("----> saveEmployee - start: EmployeeDto = {}", employeeDto);
        Employee employee = mapper.employeeDtoToEmployee(employeeDto);
        //   EmployeeDto dto = mapper.employeeToEmployeeDto(service.create(employee));
        EmployeeReadDto dto = mapper.employeeToEmployeeReadDto(service.create(employee));
        log.info("----> saveEmployee - end: EmployeeDto = {}", dto);
        return dto;
    }


//    //Операция сохранения юзера в базу данных
//    @PostMapping("/users")
//    @ResponseStatus(HttpStatus.CREATED)
//    public EmployeeReadDto saveEmployee(@RequestBody EmployeeReadDto employeeReadDto) {
//        Employee employee = mapper.employeeReadDtoToEmployee(employeeReadDto);
//        EmployeeReadDto dto = mapper.employeeToEmployeeReadDto(service.create(employee));
//        return dto;
//    }


    //Получение списка юзеров
    @Override
    @GetMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    public List<EmployeeReadDto> getAllUsers() {
        log.info("----> getAllUsers() - start: ");
        List<Employee> employees = service.getAll();
        List<EmployeeReadDto> employeesReadDto = new ArrayList<>();
        for (Employee employee : employees) {
            employeesReadDto.add(
                    mapper.employeeToEmployeeReadDto(employee));
        }
        log.info("----> getAllUsers()  - end:  employeesReadDto =  {}", employeesReadDto);
        return employeesReadDto;
    }

    //Получения юзера по id
    @Override
    @GetMapping(value = "/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EmployeeReadDto getEmployeeById(@PathVariable String id) {
        log.info("----> getEmployeeById() - start: id = {}" + id);
        EmployeeReadDto eRDTO = mapper.employeeToEmployeeReadDto(service.getById(id));
        log.info("----> getEmployeeById() - end: EmployeeReadDto = {}", eRDTO);
        return eRDTO;
    }

    //Обновление юзера
    @Override
    @SneakyThrows
    @PutMapping("/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EmployeeReadDto refreshEmployee(@PathVariable("id") String id, @RequestBody EmployeeDto employeeDto) {
        log.info("----> refreshEmployee() - start: ");
        Integer parseId = Integer.parseInt(id);
        log.info("----> refreshEmployee() -  end: ");
        return mapper.employeeToEmployeeReadDto(
                service.updateById(parseId, mapper.employeeDtoToEmployee(employeeDto))
        );
    }

    //Удаление по id
    @Override
    @PatchMapping("/users/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeEmployeeById(@PathVariable String id) {
        log.info("----> removeEmployeeById - start: id = {}" + id);
        Integer parseId = Integer.parseInt(id);
        service.removeById(parseId);
        log.info("----> removeEmployeeById - end: id = {}" + id);
    }

    //Удаление всех юзеров
    @Override
    @DeleteMapping("/users")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeAllUsers() {
        log.info("----> removeAllUsers() - start: ");
        service.removeAll();
        log.info("----> removeAllUsers() - end: ");
    }


    @Override
    @PostMapping("/sendEmailByCountry")
    @ResponseStatus(HttpStatus.OK)
    public void sendEmailByCountry(@RequestParam String country, @RequestParam String text) {
        log.info("----> endEmailByCountry() - start: ");
        service.sendEmailByCountry(country, text);
        log.info("----> endEmailByCountry() - end: ");
    }

    @Override
    @PostMapping("/sendEmailByCity")
    @ResponseStatus(HttpStatus.OK)
    public void sendEmailByCity(@RequestParam String cities, @RequestBody String text) {
        log.info("----> sendEmailByCity() - start: ");
        service.sendEmailByCity(cities, text);
        log.info("----> sendEmailByCity() - end: ");
    }

    @Override
    @PostMapping("/updateBaseByCountryFully")
    @ResponseStatus(HttpStatus.OK)
    public void updateByCountryFully(@RequestParam String countries) {
        log.info("----> updateByCountryFully() - start: ");
        service.updaterByCountryFully(countries);
        log.info("----> updateByCountryFully() - end: ");
    }

    @Override
    @PostMapping("/replaceNull")
    @ResponseStatus(HttpStatus.OK)
    public void replaceNull() {
        log.info("----> replaceNull() - start: ");
        service.processor();
        log.info("----> replaceNull() - end: ");
    }

    @Override
    @GetMapping("/fillDB")
    @ResponseStatus(HttpStatus.OK)
    public void fillDB(@RequestParam int numberOfTimes, @RequestParam String countriesList) {
        log.info("----> fillDB() - start: ");
        service.fillDB(numberOfTimes, countriesList);
        log.info("----> fillDB() - end: ");
    }

    @Override
    @GetMapping("/updateAllByCountry")
    @ResponseStatus(HttpStatus.OK)
    public void updateAllByCountry(@RequestParam String newCountry) {
        log.info("----> updateAllByCountry() - start: ");
        service.updateAllByCountry(newCountry);
        log.info("----> updateAllByCountry() - end: ");
    }

    @Override
    @GetMapping("/updateAllByCountrySmart")
    @ResponseStatus(HttpStatus.OK)
    public void updateAllByCountrySmart(@RequestParam String oldCountry, @RequestParam String newCountry) {
        log.info("----> updateAllByCountrySmart() - start: ");
        service.updateAllByCountrySmart(oldCountry, newCountry);
        log.info("----> updateAllByCountrySmart() - end: ");
    }

    @Override
    @PostMapping("/sendEmailOldFoto")
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> sendEmailOldFoto(@RequestParam String text) {
        log.info("----> sendEmailOldFoto() - start: ");
        log.info("----> sendEmailOldFoto() - end: ");
        return service.sendEmailOldFoto(text);
    }

    @Override
    @GetMapping("/metricsByCountry")
    @ResponseStatus(HttpStatus.OK)
    public void metricsByCountry(@RequestParam String fromCountry, @RequestParam String toCountry, @RequestParam String text) {
        log.info("----> metricsByCountry() - start: ");
        service.metricsByCountry(fromCountry, toCountry, text);
        log.info("----> metricsByCountry() - end: ");
    }

}