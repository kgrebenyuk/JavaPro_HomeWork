package com.example.demowithtests.dto;

import java.time.Instant;
import java.util.Date;


public class AddressDto {
    // public Integer id;

    public String country;
    public String city;
    public String street;
    public Date creationTime = Date.from(Instant.now());

}
