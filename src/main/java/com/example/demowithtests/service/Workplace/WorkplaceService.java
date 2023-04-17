package com.example.demowithtests.service.Workplace;

import com.example.demowithtests.domain.Passport;
import com.example.demowithtests.domain.Workplace;

import java.util.List;

public interface WorkplaceService {

    Workplace create(Workplace workplace);
    Workplace getById(Integer id);


}
