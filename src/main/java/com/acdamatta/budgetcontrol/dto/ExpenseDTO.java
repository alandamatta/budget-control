package com.acdamatta.budgetcontrol.dto;

import com.acdamatta.budgetcontrol.entity.BudgetEntity;
import com.acdamatta.budgetcontrol.entity.ExpenseTypeEntity;
import lombok.Data;

@Data
public class ExpenseDTO {

    private String value;
    private String name;
    private ExpenseTypeEntity type;
    private BudgetEntity budget;

}
