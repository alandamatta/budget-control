package com.acdamatta.budgetcontrol.converter;

import com.acdamatta.budgetcontrol.service.MoneyService;
import org.javamoney.moneta.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.AttributeConverter;

@Component
public class MoneyConverter implements AttributeConverter<Money, String> {

    private MoneyService moneyService;

    @Autowired
    public MoneyConverter(MoneyService moneyService) {
        this.moneyService = moneyService;
    }

    @Override
    public String convertToDatabaseColumn(Money money) {
        return money.getNumber().toString();
    }

    @Override
    public Money convertToEntityAttribute(String s) {
        return moneyService.toMoney(s);
    }
}
