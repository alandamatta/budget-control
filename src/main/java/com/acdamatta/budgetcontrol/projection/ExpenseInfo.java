package com.acdamatta.budgetcontrol.projection;

public interface ExpenseInfo {

    Long getId();
    String getAmount();
    String getDate();
    String getExpenseName();
    String getBudgetName();
    String getExpenseTypeName();
}
