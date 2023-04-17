package com.example.demowithtests.web.Employee;

import com.example.demowithtests.domain.Employee;
import com.example.demowithtests.dto.Employee.EmployeeRequestDto;
import com.example.demowithtests.dto.Employee.EmployeeResponseDto;
import com.example.demowithtests.dto.Passport.PassportResponseDto;
import com.example.demowithtests.service.Employee.EmployeeService;
//import com.example.demowithtests.employeeService.EmployeeServiceBean;
//import com.example.demowithtests.util.UserIsNotExistException;
import com.example.demowithtests.util.MyGlobalExceptionHandler;
import com.example.demowithtests.util.mupstruct.EmployeeMapper;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
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
@AllArgsConstructor
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Employee", description = "Employee API")
public class EmployeeControllerBean implements EmployeeController {

    private final EmployeeService employeeService;
    private final EmployeeMapper employeeMapper;

    @Override
    public EmployeeResponseDto saveEmployee(@RequestBody EmployeeRequestDto employeeRequestDto) {
        log.info("----> saveEmployee - start: EmployeeRequestDto = {}", employeeRequestDto);
        Employee employee = employeeMapper.fromRequestEmployeeDTO(employeeRequestDto);
        EmployeeResponseDto dto = employeeMapper.toResponseEmployeeDTO(employeeService.create(employee));
        log.info("----> saveEmployee - end: EmployeeRequestDto = {}", dto);
        return dto;
    }

    @Override
    public List<EmployeeResponseDto> getAllUsers() {
        log.info("----> getAllUsers() - start: ");
        List<Employee> employees = employeeService.getAll();
        List<EmployeeResponseDto> employeesReadDto = new ArrayList<>();
        for (Employee employee : employees) {
            employeesReadDto.add(
                    employeeMapper.toResponseEmployeeDTO(employee));
        }
        log.info("----> getAllUsers()  - end:  employeesReadDto =  {}", employeesReadDto);
        return employeesReadDto;
    }

    @Override
    public EmployeeResponseDto getEmployeeById(@PathVariable Integer id) {
        log.info("----> getEmployeeById() - start: id = {}" + id);
        EmployeeResponseDto eRDTO = employeeMapper.toResponseEmployeeDTO(employeeService.getById(id));
        log.info("----> getEmployeeById() - end: EmployeeResponseDto = {}", eRDTO);
        return eRDTO;
    }

    @Override
    @SneakyThrows
    public EmployeeResponseDto refreshEmployee(@PathVariable("id") String id, @RequestBody EmployeeRequestDto employeeRequestDto) {
        log.info("----> refreshEmployee() - start: ");
        Integer parseId = Integer.parseInt(id);
        log.info("----> refreshEmployee() -  end: ");
        return employeeMapper.toResponseEmployeeDTO(
                employeeService.updateById(parseId, employeeMapper.fromRequestEmployeeDTO(employeeRequestDto))
        );
    }

    @Override
    public void removeEmployeeById(@PathVariable String id) {
        log.info("----> removeEmployeeById - start: id = {}" + id);
        Integer parseId = Integer.parseInt(id);
        employeeService.removeById(parseId);
        log.info("----> removeEmployeeById - end: id = {}" + id);
    }

    @Override
    public void removeAllUsers() {
        log.info("----> removeAllUsers() - start: ");
        employeeService.removeAll();
        log.info("----> removeAllUsers() - end: ");
    }

    @Override
    public void sendEmailByCountry(@RequestParam String country, @RequestParam String text) {
        log.info("----> endEmailByCountry() - start: ");
        employeeService.sendEmailByCountry(country, text);
        log.info("----> endEmailByCountry() - end: ");
    }

    @Override
    public void sendEmailByCity(@RequestParam String cities, @RequestBody String text) {
        log.info("----> sendEmailByCity() - start: ");
        employeeService.sendEmailByCity(cities, text);
        log.info("----> sendEmailByCity() - end: ");
    }

    @Override
    public void updateByCountryFully(@RequestParam String countries) {
        log.info("----> updateByCountryFully() - start: ");
        employeeService.updaterByCountryFully(countries);
        log.info("----> updateByCountryFully() - end: ");
    }

    @Override
    public void replaceNull() {
        log.info("----> replaceNull() - start: ");
        employeeService.processor();
        log.info("----> replaceNull() - end: ");
    }

    @Override
    public void fillDB(@RequestParam int numberOfTimes, @RequestParam String countriesList) {
        log.info("----> fillDB() - start: ");
        employeeService.fillDB(numberOfTimes, countriesList);
        log.info("----> fillDB() - end: ");
    }

    @Override
    public void updateAllByCountry(@RequestParam String newCountry) {
        log.info("----> updateAllByCountry() - start: ");
        employeeService.updateAllByCountry(newCountry);
        log.info("----> updateAllByCountry() - end: ");
    }

    @Override
    public void updateAllByCountrySmart(@RequestParam String oldCountry, @RequestParam String newCountry) {
        log.info("----> updateAllByCountrySmart() - start: ");
        employeeService.updateAllByCountrySmart(oldCountry, newCountry);
        log.info("----> updateAllByCountrySmart() - end: ");
    }

    @Override
    public List<Employee> sendEmailOldFoto(@RequestParam String text) {
        log.info("----> sendEmailOldFoto() - start: ");
        log.info("----> sendEmailOldFoto() - end: ");
        return employeeService.sendEmailOldFoto(text);
    }

    @Override
    public List<String> metricsByCountry(@RequestParam String fromCountry, @RequestParam String toCountry, @RequestParam String text) {
        log.info("----> metricsByCountry() - start: ");
        log.info("----> metricsByCountry() - end: ");
        return employeeService.metricsByCountry(fromCountry, toCountry, text);
    }

    @Override
    public EmployeeResponseDto addPassport(@RequestParam Integer employeeId, @RequestParam Integer passportId) {
        Employee employee = employeeService.addPassport(employeeId, passportId);
        EmployeeResponseDto employeeResponseDto = employeeMapper.toResponseEmployeeDTO(employee);
        return employeeResponseDto;
    }

    @Override
    public EmployeeResponseDto addPassportSafe(@PathVariable Integer uid, @PathVariable Integer pid) {
        Employee employee = employeeService.addPassport(uid, pid);
        EmployeeResponseDto employeeResponseDto = employeeMapper.toResponseEmployeeDTO(employee);
        return employeeResponseDto;
    }

    @Override
    public EmployeeResponseDto addPassport(Integer employeeId) {
        log.info("----> addPassport() - start: ");
        Employee employee = employeeService.addPassport(employeeId);
        EmployeeResponseDto employeeResponseDto = employeeMapper.toResponseEmployeeDTO(employee);
        log.info("==>  addPassport() - end: employeeResponseDto = {}", employeeResponseDto);
        return employeeResponseDto;
    }

    @Override
    public EmployeeResponseDto addWorkplace(Integer employeeId, Integer workplaceId, Integer maxEmployees) {
        log.info("==> addWorkplace() - start: employeeId = {}, workplaceId = {}", employeeId, workplaceId);

        EmployeeResponseDto employeeResponseDto = new EmployeeResponseDto();
        try {
            employeeResponseDto = employeeMapper.toResponseEmployeeDTO(employeeService.addWorkplace(employeeId, workplaceId, maxEmployees));
        } catch (MyGlobalExceptionHandler e) {
            employeeResponseDto.errorMessage = e.getMessage();
        }

        log.info("==> addWorkplace() - end: employeeResponseDto = {}", employeeResponseDto);
        return employeeResponseDto;
    }

    @Override
    public void newSaveUser(Employee employee) {
        log.info("----> save - start: employee = {}", employee);
        employeeService.save(employee);
    }

    @Override
    public void testDetach(Integer id) {
        log.info("----> testDetach() - start: id) = {}", id);
        employeeService.testDetach(id);
    }

    @Override
    public void testJoinRemove(Integer id) {
        log.info("----> testJoinRemove() - start: id) = {}", id);
        employeeService.testJoinRemove(id);
    }

}