package com.acdamatta.budgetcontrol.service;

import com.acdamatta.budgetcontrol.entity.UserPreferencesEntity;
import org.springframework.stereotype.Service;

@Service
public class UserPreferencesService {

    public UserPreferencesEntity getPreferences() {
        UserPreferencesEntity userPreferences = new UserPreferencesEntity();
        userPreferences.setCurrency("USD");
        return userPreferences;
    }

}
