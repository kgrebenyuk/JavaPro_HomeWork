package com.example.demowithtests.util.mupstruct;

import com.example.demowithtests.domain.Passport;
import com.example.demowithtests.domain.Registration;
import com.example.demowithtests.dto.Passport.PassportRequestDto;
import com.example.demowithtests.dto.Passport.PassportResponseDto;
import com.example.demowithtests.dto.Passport.RegistrationRequestDto;
import com.example.demowithtests.dto.Passport.RegistrationResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RagistrationMapper {

//    @Mapping(target="name", source="employeeDto.name")
//    @Mapping(target="country", source="employeeDto.country")
//    @Mapping(target="email", source="employeeDto.email")
//    @Mapping(target="fotos", source="employeeDto.fotos")
//    @Mapping(target="addresses", source="employeeDto.addresses")
//    @Mapping(target="isDeleted", source="employeeDto.isDeleted")
    Registration fromRequestRegistrationDto(RegistrationRequestDto registrationRequestDto);

//    PassportRequestDto passportToRequestDto(Passport passport);

    RegistrationResponseDto toResponseRegistrationDto(Registration registration);

 //   Passport responseDtoToPassport(PassportResponseDto passportResponseDto);
}
