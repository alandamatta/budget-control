package com.acdamatta.budgetcontrol.dto;

import com.acdamatta.budgetcontrol.entity.BudgetEntity;
import com.acdamatta.budgetcontrol.entity.UserPreferencesEntity;
import lombok.Data;
import org.javamoney.moneta.Money;

@Data
public class BudgetDTO {

    private long id;
    private String name;
    private String limitValue;

    private BudgetDTO() {
    }

    public static BudgetDTO newInstance() {
        return new BudgetDTO();
    }

    public BudgetDTO fromEntity(BudgetEntity budgetEntity) {
        BudgetDTO budgetDTO = newInstance();
        budgetDTO.setName(budgetEntity.getName());
        budgetDTO.setLimitValue(budgetEntity.getLimitValue().toString());
        budgetDTO.setId(budgetEntity.getId());
        return budgetDTO;
    }

    public BudgetEntity toEntity(UserPreferencesEntity userPreferences) {
        BudgetEntity budgetEntity = new BudgetEntity();
        budgetEntity.setName(name);
        budgetEntity.setLimitValue(toMoney(limitValue, userPreferences));
        return budgetEntity;
    }

    private Money toMoney(String value, UserPreferencesEntity userPreferencesEntity) {
        return Money.parse(userPreferencesEntity.getCurrency() + " " +value);
    }

}
