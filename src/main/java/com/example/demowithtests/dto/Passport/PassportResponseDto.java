package com.example.demowithtests.dto.Passport;

import lombok.ToString;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@ToString
//@Getter
//@Setter
public class PassportResponseDto {
    public Integer id;
    public final UUID serialNumber = UUID.randomUUID();
    public String firstName;
    public String secondName;
    public LocalDate birthDate;

    public Set<RegistrationRequestDto> registrations = new HashSet<>();
}
