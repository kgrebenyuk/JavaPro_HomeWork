package com.example.demowithtests.web;

import com.example.demowithtests.domain.Employee;
import com.example.demowithtests.dto.EmployeeDto;
import com.example.demowithtests.dto.EmployeeReadDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface EmployeeController {
    @Operation(summary = "This is endpoint to add a new employee.", description = "Create request to add a new employee.", tags = {"Employee"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "CREATED. The new employee is successfully created and added to database."),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND. Specified employee request not found."),
            @ApiResponse(responseCode = "409", description = "Employee already exists")})
    EmployeeReadDto saveEmployee(@RequestBody EmployeeDto employeeDto);


    @Operation(summary = "This is endpoint to get an employee by id.", description = "Create request to get an employee by id.", tags = {"Employee"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "SELECTED. The requested employee is successfully returned."),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND. Specified employee request not found.")})
    EmployeeReadDto getEmployeeById(@PathVariable String id);

    @Operation(summary = "This is endpoint to get all employees.", description = "Create request to get all employees.", tags = {"Employee"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "SELECTED. The requested employees are returned successfully."),
            @ApiResponse(responseCode = "400", description = "Invalid input")})
    List<EmployeeReadDto> getAllUsers();


    @Operation(summary = "This is endpoint to update an employee by id.", description = "Update request to update an employee by id.", tags = {"Employee"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "UPTADED. The requested employees is updateded successfully."),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND. Specified employee request not found.")})
    EmployeeReadDto refreshEmployee(@PathVariable("id") String id, @RequestBody EmployeeDto employeeDto);

    @Operation(summary = "This is endpoint to remove an employee by id.", description = "Remove request to delete an employee by id.", tags = {"Employee"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "DELETED. The requested employee is successfully deleted."),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND. Specified employee request not found.")})
    void removeEmployeeById(@PathVariable String id);

    @Operation(summary = "This is endpoint to remove all employees.", description = "Remove request to delete all employees.", tags = {"Employee"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "DELETED. The requested employees are returned successfully."),
            @ApiResponse(responseCode = "400", description = "Invalid input")})
    void removeAllUsers();


    @Operation(summary = "This is endpoint to send email to employees by country.", description = "Send request to send email to employees by country.", tags = {"Employee"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "SENT. Emails to employees by country are sent successfully."),
            @ApiResponse(responseCode = "400", description = "Invalid input")})
    void sendEmailByCountry(@RequestParam String country, @RequestParam String text);

    @Operation(summary = "This is endpoint to send email to employees by city.", description = "Send request to send email to employees by city.", tags = {"Employee"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "SENT. Emails to employees by city are sent successfully."),
            @ApiResponse(responseCode = "400", description = "Invalid input")})
    void sendEmailByCity(@RequestParam String cities, @RequestBody String text);

    @Operation(summary = "This is endpoint to update employees by country.", description = "Update request to update employees by country.", tags = {"Employee"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "UPDATED. Employees by country are updated successfully."),
            @ApiResponse(responseCode = "400", description = "Invalid input")})
    void updateByCountryFully(@RequestParam String countries);

    @Operation(summary = "This is endpoint to replace 'null' to 'false' of IsDeleted of employees.", description = "Update request to replace 'null' to 'false' of IsDeleted of employees.", tags = {"Employee"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "UPDATED. All employees' IsDeleted are updated successfully."),
            @ApiResponse(responseCode = "400", description = "Invalid input")})
    void replaceNull();

    @Operation(summary = "This is endpoint to fill 'country' of employees randomly from list.", description = "Update request to fill 'country' of employees randomly from list.", tags = {"Employee"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "UPDATED. All employees 'country' are updated successfully."),
            @ApiResponse(responseCode = "400", description = "Invalid input")})
    void fillDB(@RequestParam int numberOfTimes, @RequestParam String countriesList);

    @Operation(summary = "This is endpoint to update employees by country.", description = "Update request to update employees by country.", tags = {"Employee"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "UPDATED. Employees by country are updated successfully."),
            @ApiResponse(responseCode = "400", description = "Invalid input")})
    void updateAllByCountry(@RequestParam String newCountry);

    @Operation(summary = "This is endpoint to update employees by country smartly.", description = "Update request to update employees by country.", tags = {"Employee"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "UPDATED. Employees by country are updated successfully."),
            @ApiResponse(responseCode = "400", description = "Invalid input")})
    void updateAllByCountrySmart(@RequestParam String oldCountry, @RequestParam String newCountry);

    @Operation(summary = "This is endpoint to send an email to employees to update the foto.", description = "Request to send an email to employees to update the foto.", tags = {"Employee"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "SENT. Employees by informed to update their foto successfully."),
            @ApiResponse(responseCode = "400", description = "Invalid input")})
    List<Employee> sendEmailOldFoto(@RequestParam String text);


    @Operation(summary = "This is endpoint to send an email to selected employees by 'fromCountry', 'toCountry'", description = "Request to send an email to selected employees by 'fromCountry', 'toCountry'.", tags = {"Employee"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "SENT. Employees by 'fromCountry', 'toCountry' are informed successfully."),
            @ApiResponse(responseCode = "400", description = "Invalid input")})
    void metricsByCountry(@RequestParam String fromCountry, @RequestParam String toCountry, @RequestParam String text);
}
