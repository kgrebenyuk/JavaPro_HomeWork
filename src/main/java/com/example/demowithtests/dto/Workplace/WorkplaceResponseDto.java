package com.example.demowithtests.dto.Workplace;

import com.example.demowithtests.domain.Employee;
import com.example.demowithtests.dto.Passport.RegistrationRequestDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.ToString;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@ToString
//@Getter
//@Setter
public class WorkplaceResponseDto {
    @Schema(description = "Info of name", example = "")
    public String name;
    @Schema(description = "Info of address", example = "")
    public String address;
//    @Schema(description = "Info of employees", example = "")
//    public Set<Employee> employees = new HashSet<>();;
}
