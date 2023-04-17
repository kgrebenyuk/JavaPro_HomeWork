package com.example.demowithtests.service.Workplace;

import com.example.demowithtests.domain.Passport;
import com.example.demowithtests.domain.Workplace;
import com.example.demowithtests.repository.PassportRepository;
import com.example.demowithtests.repository.WorkplaceRepository;
import com.example.demowithtests.util.IdIsNotExistException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
@Slf4j
public class WorkplaceServiceBin implements WorkplaceService {

    private final WorkplaceRepository workplaceRepository;


    @Override
    public Workplace create(Workplace workplace) {
        log.info("----> addWorkplace() - start: ", workplace);
        return workplaceRepository.save(workplace);
    }

    @Override
    public Workplace getById(Integer id) {
        log.info("----> getByIdWorkplace() - start: ", id);
        return workplaceRepository.findById(id).orElseThrow(IdIsNotExistException::new);
    }


}
