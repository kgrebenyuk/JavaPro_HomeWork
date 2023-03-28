package com.example.demowithtests.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.Instant;
import java.util.Date;


public class AddressDto {
    // public Integer id;

    @Schema(description = "Country of Address.", example = "Ukraine", required = true)
    public String country;
    @Schema(description = "City of Address.", example = "Odessa", required = true)
    public String city;
    @Schema(description = "Street of Address.", example = "Deribasovska", required = true)
    public String street;
    @Schema(description = "CreationTime of Address.", example = "", required = true)
    public Date creationTime = Date.from(Instant.now());

}
