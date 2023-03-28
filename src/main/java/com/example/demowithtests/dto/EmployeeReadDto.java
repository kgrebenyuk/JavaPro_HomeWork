package com.example.demowithtests.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class EmployeeReadDto {
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

}
