package com.example.demowithtests.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.UUID;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "passports")
public class Passport {
    private int id;
    private String fisrtName;
    private String secondName;
    private final  UUID serialNumber = UUID.randomUUID();
    private LocalDate birthDate;


}
