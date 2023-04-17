package com.example.demowithtests.service.Passport;

import com.example.demowithtests.domain.Passport;
import com.example.demowithtests.repository.PassportRepository;
import com.example.demowithtests.util.IdIsNotExistException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
@Slf4j
public class PassportServiceBin implements PassportService {

    private final PassportRepository passportRepository;


    @Override
    public Passport create(Passport passport) {
        return passportRepository.save(passport);
    }

    @Override
    public List<Passport> getAll() {
        return passportRepository.findAll();
    }

    @Override
    public Passport getById(Integer id) {
        return passportRepository.findById(id).orElseThrow(IdIsNotExistException::new);
    }

    @Override
    public Passport updateById(Integer id, Passport plane) {
        Passport entity = passportRepository.findById(id).orElseThrow(IdIsNotExistException::new);
        entity.setFirstName(entity.getFirstName());
        entity.setSecondName(entity.getSecondName());
        Passport updatePassport = passportRepository.save(entity);

        return updatePassport;
    }
}
