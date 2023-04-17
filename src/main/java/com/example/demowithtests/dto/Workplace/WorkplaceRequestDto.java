package com.example.demowithtests.dto.Workplace;

import com.example.demowithtests.domain.Employee;
import com.example.demowithtests.dto.Passport.RegistrationRequestDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@ToString
public class WorkplaceRequestDto {

    @Schema(description = "Info of id", example = "")
    public Integer id;
    @Schema(description = "Info of name", example = "")
    public String name;
    @Schema(description = "Info of address", example = "")
    public String address;
//    @Schema(description = "Info of employees", example = "")
//    public Set<Employee> employees = new HashSet<>();;
}
