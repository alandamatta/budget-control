package com.acdamatta.budgetcontrol.service;

import com.acdamatta.budgetcontrol.entity.UserEntity;
import org.springframework.stereotype.Service;

@Service
public class SessionService {

    public UserEntity getLoggedUser() {
        UserEntity user = new UserEntity();
        user.setId(1);
        return user;
    }

}
