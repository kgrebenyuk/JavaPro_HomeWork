package com.example.demowithtests.dto.Employee;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.Instant;
import java.util.Date;


public class FotoDto {
    //  public Integer id;
    @Schema(description = "Link to foto.", example = "", required = false)
    public String link;
    @Schema(description = "length of foto.", example = "1000", required = false)
    public Integer length;
    @Schema(description = "width of foto.", example = "2000", required = false)
    public Integer width;
    @Schema(description = "isVisible of foto.", example = "", required = false)
    public Boolean isVisible = Boolean.TRUE;
    @Schema(description = "Creation Time of foto.", example = "", required = false)
    public Date creationTime = Date.from(Instant.now());

}
