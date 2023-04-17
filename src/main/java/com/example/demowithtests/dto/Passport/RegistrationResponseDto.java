package com.example.demowithtests.dto.Passport;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.Instant;
import java.util.Date;


public class RegistrationResponseDto {
    //  public Integer id;

    @Schema(description = "Info of regiastration.", example = "", required = false)
    public String info;

    @Schema(description = "Is  regiastration Active ?.", example = "", required = true)
    public Boolean isActive = Boolean.TRUE;

    @Schema(description = "Creation Time of regiastration.", example = "", required = false)
    public Date creationTime = Date.from(Instant.now());

}
