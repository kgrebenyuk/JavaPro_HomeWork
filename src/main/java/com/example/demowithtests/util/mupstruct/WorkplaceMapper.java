package com.example.demowithtests.util.mupstruct;

import com.example.demowithtests.domain.Employee;
import com.example.demowithtests.domain.Workplace;
import com.example.demowithtests.dto.Employee.EmployeeRequestDto;
import com.example.demowithtests.dto.Employee.EmployeeResponseDto;
import com.example.demowithtests.dto.Workplace.WorkplaceRequestDto;
import com.example.demowithtests.dto.Workplace.WorkplaceResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface WorkplaceMapper {

    Workplace fromRequestWorkplaceDto(WorkplaceRequestDto workplaceRequestDto);

    WorkplaceResponseDto toResponseWorkplaceDto(Workplace workplace);
}
