package com.example.demowithtests.util.mupstruct;

import com.example.demowithtests.domain.Employee;
import com.example.demowithtests.dto.Employee.EmployeeRequestDto;
import com.example.demowithtests.dto.Employee.EmployeeResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

//    @Mapping(target="name", source="employeeRequestDto.name")
//    @Mapping(target="country", source="employeeRequestDto.country")
//    @Mapping(target="email", source="employeeRequestDto.email")
//    @Mapping(target="fotos", source="employeeRequestDto.fotos")
//    @Mapping(target="addresses", source="employeeRequestDto.addresses")
//    @Mapping(target="isDeleted", source="employeeRequestDto.isDeleted")
    Employee fromRequestEmployeeDTO(EmployeeRequestDto employeeRequestDto);

//    EmployeeRequestDto employeeToEmployeeDto(Employee employee);

    EmployeeResponseDto toResponseEmployeeDTO(Employee employee);

 //   Employee employeeReadDtoToEmployee(EmployeeResponseDto employeeResponseDto);
}
