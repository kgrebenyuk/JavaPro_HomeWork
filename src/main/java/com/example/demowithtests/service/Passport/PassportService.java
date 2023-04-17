package com.example.demowithtests.service.Passport;

import com.example.demowithtests.domain.Passport;
import java.util.List;

public interface PassportService {
    Passport create(Passport passport);
    List<Passport> getAll();
    Passport getById(Integer id);
    Passport updateById(Integer id, Passport plane);

}
