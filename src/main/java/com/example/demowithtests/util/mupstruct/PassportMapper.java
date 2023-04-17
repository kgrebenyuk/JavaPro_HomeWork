package com.example.demowithtests.util.mupstruct;

import com.example.demowithtests.domain.Passport;
import com.example.demowithtests.dto.Passport.PassportRequestDto;
import com.example.demowithtests.dto.Passport.PassportResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PassportMapper {

//    @Mapping(target="name", source="employeeDto.name")
//    @Mapping(target="country", source="employeeDto.country")
//    @Mapping(target="email", source="employeeDto.email")
//    @Mapping(target="fotos", source="employeeDto.fotos")
//    @Mapping(target="addresses", source="employeeDto.addresses")
//    @Mapping(target="isDeleted", source="employeeDto.isDeleted")
    Passport fromRequestPassportDto(PassportRequestDto passportRequestDto);

//    PassportRequestDto passportToRequestDto(Passport passport);

    PassportResponseDto toResponsePassportDto(Passport passport);

 //   Passport responseDtoToPassport(PassportResponseDto passportResponseDto);
}
