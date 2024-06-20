package com.devkh.courseservice.repository;

import com.devkh.courseservice.model.UserInfm;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserInfmRepository extends CrudRepository<UserInfm, Integer> {
    Optional<UserInfm> findByEmail(String email);
}
