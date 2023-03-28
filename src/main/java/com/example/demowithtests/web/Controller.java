package com.example.demowithtests.web;

import com.example.demowithtests.domain.Employee;
import com.example.demowithtests.dto.EmployeeDto;
import com.example.demowithtests.dto.EmployeeReadDto;
import com.example.demowithtests.service.Service;
//import com.example.demowithtests.service.ServiceBean;
//import com.example.demowithtests.util.UserIsNotExistException;
import com.example.demowithtests.util.config.Mapper;
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
public class Controller {

    private final Service service;
    private final Mapper mapper;

    //   private static final Logger log = Logger.getLogger(ServiceBean.class.getName());


    public Controller(Service service, Mapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }


    /////////////////
    //Операция сохранения юзера в базу данных
    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public EmployeeDto saveEmployee(@RequestBody EmployeeDto employeeDto) {
        log.info("----> saveEmployee - start: EmployeeDto = {}", employeeDto);

        Employee employee = mapper.employeeDtoToEmployee(employeeDto);
        EmployeeDto dto = mapper.employeeToEmployeeDto(service.create(employee));

        log.info("----> saveEmployee - end: EmployeeDto = {}", dto);
        return dto;
    }

//

//    //Операция сохранения юзера в базу данных
//    @PostMapping("/users")
//    @ResponseStatus(HttpStatus.CREATED)
//    public EmployeeReadDto saveEmployee(@RequestBody EmployeeReadDto employeeReadDto) {
//        Employee employee = mapper.employeeReadDtoToEmployee(employeeReadDto);
//        EmployeeReadDto dto = mapper.employeeToEmployeeReadDto(service.create(employee));
//        return dto;
//    }

////////////////////////////


    //Получение списка юзеров
    @GetMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    public List<EmployeeReadDto> getAllUsers() {
        List<Employee> employees = service.getAll();
        List<EmployeeReadDto> employeesReadDto = new ArrayList<>();
        for (Employee employee : employees) {
            employeesReadDto.add(
                    mapper.employeeToEmployeeReadDto(employee)
            );
        }
        return employeesReadDto;
    }

    //Получения юзера по id
    @GetMapping(value = "/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EmployeeReadDto getEmployeeById(@PathVariable String id) {

        log.info("----> getEmployeeById() - start: id = {}" + id);

        EmployeeReadDto eRDTO = mapper.employeeToEmployeeReadDto(service.getById(id));

        log.info("----> getEmployeeById() - end: EmployeeReadDto = {}" + eRDTO);

        return eRDTO;
    }

    //Обновление юзера
    @SneakyThrows
    @PutMapping("/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EmployeeReadDto refreshEmployee(@PathVariable("id") String id, @RequestBody EmployeeDto employeeDto) {
        Integer parseId = Integer.parseInt(id);
        return mapper.employeeToEmployeeReadDto(
                service.updateById(parseId, mapper.employeeDtoToEmployee(employeeDto)
                )
        );
    }

    //Удаление по id
    @PatchMapping("/users/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeEmployeeById(@PathVariable String id) {
        log.info("----> removeEmployeeById - start: id = {}" + id);

        Integer parseId = Integer.parseInt(id);
        service.removeById(parseId);

        log.info("----> removeEmployeeById - end: id = {}" + id);

    }

    //Удаление всех юзеров
    @DeleteMapping("/users")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeAllUsers() {
        service.removeAll();
    }


    @PostMapping("/sendEmailByCountry")
    @ResponseStatus(HttpStatus.OK)
    public void sendEmailByCountry(@RequestParam String country, @RequestParam String text) {
        service.sendEmailByCountry(country, text);
    }

    @PostMapping("/sendEmailByCity")
    @ResponseStatus(HttpStatus.OK)
    public void sendEmailByCity(@RequestParam String cities, @RequestBody String text) {
        service.sendEmailByCity(cities, text);
    }

    @PostMapping("/updateBaseByCountryFully")
    @ResponseStatus(HttpStatus.OK)
    public void updateByCountryFully(@RequestParam String countries) {
        service.updaterByCountryFully(countries);
    }


    @PostMapping("/replaceNull")
    @ResponseStatus(HttpStatus.OK)
    public void replaceNull() {
        service.processor();
    }

    ///////-----------
    @GetMapping("/fillDB")
    @ResponseStatus(HttpStatus.OK)
    public void fillDB(@RequestParam int numberOfTimes, @RequestParam String countriesList) {
        service.fillDB(numberOfTimes, countriesList);
    }

    @GetMapping("/updateAllByCountry")
    @ResponseStatus(HttpStatus.OK)
    public void updateAllByCountry(@RequestParam String newCountry) {
        service.updateAllByCountry(newCountry);
    }

    @GetMapping("/updateAllByCountrySmart")
    @ResponseStatus(HttpStatus.OK)
    public void updateAllByCountrySmart(@RequestParam String oldCountry, @RequestParam String newCountry) {
        service.updateAllByCountrySmart(oldCountry, newCountry);
    }

    @PostMapping("/sendEmailOldFoto")
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> sendEmailOldFoto(@RequestParam String text) {
        return service.sendEmailOldFoto(text);

    }

}