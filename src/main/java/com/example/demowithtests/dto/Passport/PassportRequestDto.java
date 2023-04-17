package com.example.demowithtests.dto.Passport;

import lombok.ToString;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@ToString
public class PassportRequestDto {

    public String firstName;
    public String secondName;
    public LocalDate birthDate;
    public Set<RegistrationRequestDto> registrations = new HashSet<>();
}
