package com.example.demowithtests.web.Workplace;

import com.example.demowithtests.domain.Passport;
import com.example.demowithtests.domain.Workplace;
import com.example.demowithtests.dto.Passport.PassportRequestDto;
import com.example.demowithtests.dto.Passport.PassportResponseDto;
import com.example.demowithtests.dto.Workplace.WorkplaceRequestDto;
import com.example.demowithtests.dto.Workplace.WorkplaceResponseDto;
import com.example.demowithtests.service.Passport.PassportService;
import com.example.demowithtests.service.Workplace.WorkplaceService;
import com.example.demowithtests.util.mupstruct.PassportMapper;
import com.example.demowithtests.util.mupstruct.WorkplaceMapper;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
@Tag(name = "Workplace", description = "Workplace API")
public class WorkplaceControllerBean implements WorkplaceController {

    private final WorkplaceService workplaceService;
    private final WorkplaceMapper workplaceMapper;


    @Override
    @PostMapping("/workplace")
    @ResponseStatus(HttpStatus.CREATED)
    public WorkplaceResponseDto saveWorkplace(WorkplaceRequestDto workplaceRequestDto) {
        log.info("----> saveWorkplace - start: WorkplaceRequestDto = {}", workplaceRequestDto);
        Workplace workplace = workplaceMapper.fromRequestWorkplaceDto(workplaceRequestDto);
        WorkplaceResponseDto workplaceResponseDto = workplaceMapper.toResponseWorkplaceDto(workplaceService.create(workplace));
        log.info("----> saveWorkplace- end: WorkplaceResponseDto = {}", workplaceResponseDto);
        return workplaceResponseDto;
    }

    @Override
    @GetMapping(value = "/workplace/{id}")
    @ResponseStatus(HttpStatus.OK)
    public WorkplaceResponseDto getWorkplaceById(Integer id) {
        log.info("----> getWorkplaceById - start: id = {}", id);
        Workplace workplace = workplaceService.getById(id);
        WorkplaceResponseDto workplaceResponseDto = workplaceMapper.toResponseWorkplaceDto(workplace);
        log.info("----> getWorkplaceById - end: WorkplaceResponseDto = {}", workplaceResponseDto);
        return workplaceResponseDto;
    }

}
