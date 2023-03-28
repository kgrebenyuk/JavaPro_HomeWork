package com.example.demowithtests.dto;

import java.time.Instant;
import java.util.Date;


public class FotoDto {
    //  public Integer id;
    public String link;
    public String length;
    public Integer width;
    public Boolean isVisible = Boolean.TRUE;
    public Date creationTime = Date.from(Instant.now());

}
