package com.example.demowithtests.dto.Employee;

import com.example.demowithtests.dto.Passport.PassportResponseDto;
import com.example.demowithtests.dto.Workplace.WorkplaceResponseDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@ToString
//@Getter
//@Setter
public class EmployeeResponseDto {
    @Schema(description = "Name of an employee.", example = "Billy", required = true)
    public String name;

    @Schema(description = "Email of an employee.", example = "Billy@gmail.com", required = true)
    public String email;

    @Schema(description = "Creation Time of an employee.", example = "", required = false)
    public Date creationTime = Date.from(Instant.now());

    @Schema(description = "Fotos of an employee.", example = "", required = true)
    public Set<FotoDto> fotos = new HashSet<>();

    @Schema(description = "Addresses of an employee.", example = "", required = true)
    public Set<AddressDto> addresses = new HashSet<>();

    @Schema(description = "Passport of an employee.", example = "", required = true)
    public PassportResponseDto passport;

    @Schema(description = "Workplace of an employee.", example = "", required = true)
    public Set<WorkplaceResponseDto> workplaces;


    @Schema(description = "errorMessage", example = "", required = false)
    public String errorMessage;
}
