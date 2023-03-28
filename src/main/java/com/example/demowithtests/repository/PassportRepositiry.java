package com.example.demowithtests.repository;

import com.example.demowithtests.domain.Passport;
import org.springframework.stereotype.Repository;

@Repository
public interface PassportRepositiry extends JpaRepository<Integer, Passport>{


}
