package com.acdamatta.budgetcontrol.projection;

public interface BudgetInfo {

    Long getId();
    String getName();
    String getLimitValue();
    String getTotalExpenses();
    String getLimitValueText();
    String getTotalExpensesText();

}
