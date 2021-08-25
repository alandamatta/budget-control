package com.acdamatta.budgetcontrol.service;

import com.acdamatta.budgetcontrol.entity.ExpenseEntity;
import com.acdamatta.budgetcontrol.entity.UserEntity;
import com.acdamatta.budgetcontrol.projection.ExpenseInfo;
import com.acdamatta.budgetcontrol.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExpenseService {

    private ExpenseRepository expenseRepository;

    private MoneyService moneyService;

    private ExpenseTypeService expenseTypeService;

    private BudgetService budgetService;

    @Autowired
    public ExpenseService(ExpenseRepository expenseRepository,
                          MoneyService moneyService,
                          ExpenseTypeService expenseTypeService,
                          BudgetService budgetService) {
        this.expenseRepository = expenseRepository;
        this.moneyService = moneyService;
        this.expenseTypeService = expenseTypeService;
        this.budgetService = budgetService;
    }

    public ExpenseEntity create(ExpenseEntity expense) {
        UserEntity ue = new UserEntity();
        ue.setId(1);
        expense.setDataOwner(ue);
        return expenseRepository.save(expense);
    }

    public List<ExpenseEntity> findAll() {
        List<ExpenseEntity> expenses = new ArrayList<>();
        final Iterable<ExpenseEntity> expensesIterable = expenseRepository.findAll();
        expensesIterable.forEach(expenses::add);
        return expenses;
    }

    public void deleteById(Long expenseId) {
        expenseRepository.deleteById(expenseId);
    }

    public List<ExpenseInfo> findAllWithCurrencySymbol() {
        return expenseRepository.findAllWithCurrencySymbol();
    }
}
