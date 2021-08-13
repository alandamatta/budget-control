package com.acdamatta.budgetcontrol.service;

import com.acdamatta.budgetcontrol.entity.ExpenseTypeEntity;
import com.acdamatta.budgetcontrol.repository.ExpenseTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ExpenseTypeService {

    private ExpenseTypeRepository expenseTypeRepository;

    @Autowired
    public ExpenseTypeService(ExpenseTypeRepository expenseTypeRepository) {
        this.expenseTypeRepository = expenseTypeRepository;
    }

    public ExpenseTypeEntity create(ExpenseTypeEntity expenseType) {
        return expenseTypeRepository.save(expenseType);
    }

    public List<ExpenseTypeEntity> findAll() {
        List<ExpenseTypeEntity> expenseTypes = new ArrayList<>();
        final Iterable<ExpenseTypeEntity> expensesIterable = expenseTypeRepository.findAll();
        expensesIterable.forEach(expenseTypes::add);
        return expenseTypes;
    }

    public Optional<ExpenseTypeEntity> findById(long id) {
        return expenseTypeRepository.findById(id);
    }

}
