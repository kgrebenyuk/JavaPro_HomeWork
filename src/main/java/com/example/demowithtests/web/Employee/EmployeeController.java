package com.example.demowithtests.web.Employee;

import com.example.demowithtests.domain.Employee;
import com.example.demowithtests.dto.Employee.EmployeeRequestDto;
import com.example.demowithtests.dto.Employee.EmployeeResponseDto;
import com.example.demowithtests.util.MyGlobalExceptionHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    EmployeeResponseDto saveEmployee(@RequestBody EmployeeRequestDto employeeRequestDto);

    @Operation(summary = "This is endpoint to get all employees.", description = "Create request to get all employees.", tags = {"Employee"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "SELECTED. The requested employees are returned successfully."),
            @ApiResponse(responseCode = "400", description = "Invalid input")})
    @GetMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    List<EmployeeResponseDto> getAllUsers();

    @Operation(summary = "This is endpoint to get an employee by id.", description = "Create request to get an employee by id.", tags = {"Employee"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "SELECTED. The requested employee is successfully returned."),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND. Specified employee request not found.")})
    @GetMapping(value = "/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    EmployeeResponseDto getEmployeeById(@PathVariable Integer id);

    @Operation(summary = "This is endpoint to update an employee by id.", description = "Update request to update an employee by id.", tags = {"Employee"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "UPTADED. The requested employees is updateded successfully."),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND. Specified employee request not found.")})
    @PutMapping("/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    EmployeeResponseDto refreshEmployee(@PathVariable("id") String id, @RequestBody EmployeeRequestDto employeeRequestDto);

    @Operation(summary = "This is endpoint to remove an employee by id.", description = "Remove request to delete an employee by id.", tags = {"Employee"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "DELETED. The requested employee is successfully deleted."),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND. Specified employee request not found.")})
    @PatchMapping("/users/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void removeEmployeeById(@PathVariable String id);

    @Operation(summary = "This is endpoint to remove all employees.", description = "Remove request to delete all employees.", tags = {"Employee"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "DELETED. The requested employees are returned successfully."),
            @ApiResponse(responseCode = "400", description = "Invalid input")})
    @DeleteMapping("/users")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void removeAllUsers();


    @Operation(summary = "This is endpoint to send email to employees by country.", description = "Send request to send email to employees by country.", tags = {"Employee"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "SENT. Emails to employees by country are sent successfully."),
            @ApiResponse(responseCode = "400", description = "Invalid input")})
    @PostMapping("/sendEmailByCountry")
    @ResponseStatus(HttpStatus.OK)
    void sendEmailByCountry(@RequestParam String country, @RequestParam String text);

    @Operation(summary = "This is endpoint to send email to employees by city.", description = "Send request to send email to employees by city.", tags = {"Employee"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "SENT. Emails to employees by city are sent successfully."),
            @ApiResponse(responseCode = "400", description = "Invalid input")})
    @PostMapping("/sendEmailByCity")
    @ResponseStatus(HttpStatus.OK)
    void sendEmailByCity(@RequestParam String cities, @RequestBody String text);

    @Operation(summary = "This is endpoint to update employees by country.", description = "Update request to update employees by country.", tags = {"Employee"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "UPDATED. Employees by country are updated successfully."),
            @ApiResponse(responseCode = "400", description = "Invalid input")})
    @PostMapping("/updateBaseByCountryFully")
    @ResponseStatus(HttpStatus.OK)
    void updateByCountryFully(@RequestParam String countries);

    @Operation(summary = "This is endpoint to replace 'null' to 'false' of IsDeleted of employees.", description = "Update request to replace 'null' to 'false' of IsDeleted of employees.", tags = {"Employee"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "UPDATED. All employees' IsDeleted are updated successfully."),
            @ApiResponse(responseCode = "400", description = "Invalid input")})
    @PostMapping("/replaceNull")
    @ResponseStatus(HttpStatus.OK)
    void replaceNull();

    @Operation(summary = "This is endpoint to fill 'country' of employees randomly from list.", description = "Update request to fill 'country' of employees randomly from list.", tags = {"Employee"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "UPDATED. All employees 'country' are updated successfully."),
            @ApiResponse(responseCode = "400", description = "Invalid input")})
    @GetMapping("/fillDB")
    @ResponseStatus(HttpStatus.OK)
    void fillDB(@RequestParam int numberOfTimes, @RequestParam String countriesList);

    @Operation(summary = "This is endpoint to update employees by country.", description = "Update request to update employees by country.", tags = {"Employee"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "UPDATED. Employees by country are updated successfully."),
            @ApiResponse(responseCode = "400", description = "Invalid input")})
    @GetMapping("/updateAllByCountry")
    @ResponseStatus(HttpStatus.OK)
    void updateAllByCountry(@RequestParam String newCountry);

    @Operation(summary = "This is endpoint to update employees by country smartly.", description = "Update request to update employees by country.", tags = {"Employee"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "UPDATED. Employees by country are updated successfully."),
            @ApiResponse(responseCode = "400", description = "Invalid input")})
    @GetMapping("/updateAllByCountrySmart")
    @ResponseStatus(HttpStatus.OK)
    void updateAllByCountrySmart(@RequestParam String oldCountry, @RequestParam String newCountry);

    @Operation(summary = "This is endpoint to send an email to employees to update the foto.", description = "Request to send an email to employees to update the foto.", tags = {"Employee"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "SENT. Employees by informed to update their foto successfully."),
            @ApiResponse(responseCode = "400", description = "Invalid input")})
    @PostMapping("/sendEmailOldFoto")
    @ResponseStatus(HttpStatus.OK)
    List<Employee> sendEmailOldFoto(@RequestParam String text);

    @Operation(summary = "This is endpoint to send an email to selected employees by 'fromCountry', 'toCountry'", description = "Request to send an email to selected employees by 'fromCountry', 'toCountry'.", tags = {"Employee"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "SENT. Employees by 'fromCountry', 'toCountry' are informed successfully."),
            @ApiResponse(responseCode = "400", description = "Invalid input")})
    @GetMapping("/metricsByCountry")
    @ResponseStatus(HttpStatus.OK)
    List<String> metricsByCountry(@RequestParam String fromCountry, @RequestParam String toCountry, @RequestParam String text);

    @Operation(summary = "This is endpoint to add the passport to employee.", description = "Update request to add an passport to employee.", tags = {"Passport"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "UPTADED. The requested passport is added successfully."),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND. Specified passport request not found.")})
    @PatchMapping("/addPassport")
    @ResponseStatus(HttpStatus.OK)
    EmployeeResponseDto addPassport(@RequestParam Integer employeeId, @RequestParam Integer passportId);

    @Operation(summary = "This is endpoint to add the passport to employee securely.", description = "Update request to add an passport to employee securely.", tags = {"Passport"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "UPTADED. The requested passport is added successfully."),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND. Specified passport request not found.")})
    @PatchMapping("/users/{uid}/passports/{pid}")
    @ResponseStatus(HttpStatus.OK)
    EmployeeResponseDto addPassportSafe(@PathVariable Integer uid, @PathVariable Integer pid);

    @PutMapping("/users/{uid}/passports")
    @ResponseStatus(HttpStatus.OK)
    EmployeeResponseDto addPassport(@PathVariable("employeeId") Integer employeeId);

    @Operation(summary = "This is endpoint to add the workplace to employee.", description = "Create request to add the workplace to employee.", tags = {"Employee"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Email successfully sent."),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND. Specified employee request not found.")})
    @PostMapping("/employee/{id}/workplace/{workplaceId}/maxEmployees/{maxEmployees}")
    @ResponseStatus(HttpStatus.OK)
    EmployeeResponseDto addWorkplace(@PathVariable("id") Integer id, @PathVariable("workplaceId") Integer workplaceId, @PathVariable("maxEmployees") Integer maxEmployees) throws MyGlobalExceptionHandler;
}
