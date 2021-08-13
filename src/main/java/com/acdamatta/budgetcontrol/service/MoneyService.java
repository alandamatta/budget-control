package com.acdamatta.budgetcontrol.service;

import com.acdamatta.budgetcontrol.entity.UserPreferencesEntity;
import org.javamoney.moneta.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MoneyService {

    private UserPreferencesService userPreferencesService;

    @Autowired
    public MoneyService(UserPreferencesService userPreferencesService) {
        this.userPreferencesService = userPreferencesService;
    }

    public Money toMoney(String value) {
        return Money.parse(userPreferences().getCurrency() + " " +value);
    }

    private UserPreferencesEntity userPreferences() {
        return userPreferencesService.getPreferences();
    }

}
