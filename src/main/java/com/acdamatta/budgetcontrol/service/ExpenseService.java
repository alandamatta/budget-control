package com.acdamatta.budgetcontrol.service;

import com.acdamatta.budgetcontrol.dto.ExpenseDTO;
import com.acdamatta.budgetcontrol.entity.BudgetEntity;
import com.acdamatta.budgetcontrol.entity.ExpenseEntity;
import com.acdamatta.budgetcontrol.entity.ExpenseTypeEntity;
import com.acdamatta.budgetcontrol.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        return expenseRepository.save(expense);
    }

    public List<ExpenseEntity> findAll() {
        List<ExpenseEntity> expenses = new ArrayList<>();
        final Iterable<ExpenseEntity> expensesIterable = expenseRepository.findAll();
        expensesIterable.forEach(expenses::add);
        return expenses;
    }

    public ExpenseDTO toDTO(ExpenseEntity expense) {
        ExpenseDTO expenseDTO = new ExpenseDTO();
        expenseDTO.setName(expense.getName());
        expenseDTO.setType(expense.getExpenseType());
        expenseDTO.setValue(expense.getValue().toString());
        expenseDTO.setBudget(expense.getBudget());
        return expenseDTO;
    }

    public ExpenseEntity fromDTO(ExpenseDTO expenseDTO) {
        ExpenseEntity expense = new ExpenseEntity();
        expense.setName(expenseDTO.getName());
        expense.setValue(moneyService.toMoney(expenseDTO.getValue()));
        final Optional<ExpenseTypeEntity> expenseType = expenseTypeService.findById(expenseDTO.getType().getId());
        final Optional<BudgetEntity> budget = budgetService.findById(expenseDTO.getBudget().getId());
        expense.setExpenseType(expenseType.orElseThrow());
        expense.setBudget(budget.orElseThrow());
        return expense;
    }

}
