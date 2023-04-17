package com.example.demowithtests.web.Workplace;

import com.example.demowithtests.dto.Passport.PassportRequestDto;
import com.example.demowithtests.dto.Passport.PassportResponseDto;
import com.example.demowithtests.dto.Workplace.WorkplaceRequestDto;
import com.example.demowithtests.dto.Workplace.WorkplaceResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface WorkplaceController {

    @Operation(summary = "This is endpoint to add a new workplace.", description = "Create request to add a new  workplace.", tags = {"Workplace"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "CREATED. The new  workplace is successfully created and added to database."),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND. Specified  workplace request not found."),
            @ApiResponse(responseCode = "409", description = " Workplace already exists")})
    WorkplaceResponseDto saveWorkplace(@RequestBody WorkplaceRequestDto workplaceRequestDto);


    @Operation(summary = "This is endpoint to get an workplace by id.", description = "Create request to get an workplace by id.", tags = {"Workplace"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "SELECTED. The requested workplace is successfully returned."),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND. Specified workplace request not found.")})
    WorkplaceResponseDto getWorkplaceById(@PathVariable Integer id);


}
