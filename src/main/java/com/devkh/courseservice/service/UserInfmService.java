package com.devkh.courseservice.service;

//import com.devkh.courseservice.model.UserInfm;
//import com.devkh.courseservice.repository.UserInfmRepository;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class UserInfmService {
//    private final UserInfmRepository userInfmRepository;
//
//    public UserInfmService(UserInfmRepository userInfmRepository) {
//        this.userInfmRepository = userInfmRepository;
//    }
//
//
//    public List<UserInfm> allUsers() {
//        List<UserInfm> users = new ArrayList<>();
//
//        userInfmRepository.findAll().forEach(users::add);
//
//        return users;
//    }
//}


import com.devkh.courseservice.model.UserInfm;
import com.devkh.courseservice.repository.UserInfmRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfmService {
    private final UserInfmRepository userInfmRepository;

    public UserInfmService(UserInfmRepository userInfmRepository) {
        this.userInfmRepository = userInfmRepository;
    }

    public List<UserInfm> allUsers() {
        return (List<UserInfm>) userInfmRepository.findAll();
    }
}


