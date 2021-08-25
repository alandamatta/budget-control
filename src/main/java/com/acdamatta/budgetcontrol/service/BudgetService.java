package com.acdamatta.budgetcontrol.service;

import com.acdamatta.budgetcontrol.entity.BudgetEntity;
import com.acdamatta.budgetcontrol.repository.BudgetRepository;
import com.acdamatta.budgetcontrol.projection.BudgetInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BudgetService {

    private final BudgetRepository budgetRepository;

    @Autowired
    public BudgetService(BudgetRepository budgetRepository) {
        this.budgetRepository = budgetRepository;
    }

    public BudgetEntity create(BudgetEntity budgetEntity) {
        return budgetRepository.save(budgetEntity);
    }

    public Optional<BudgetEntity> findById(Long id) {
        return budgetRepository.findById(id);
    }

    public List<BudgetEntity> findAll() {
        final Iterable<BudgetEntity> budgetEntityIterate = budgetRepository.findAll();
        List<BudgetEntity> budgetEntityList = new ArrayList<>();
        budgetEntityIterate.forEach(budgetEntityList::add);
        return budgetEntityList;
    }

    public List<BudgetInfo> findAllBudgetInfo() {
        return budgetRepository.getAllBudgetsInfo();
    }

    public void deleteById(long budgetId) {
        final Optional<BudgetEntity> budget = findById(budgetId);
        budgetRepository.delete(budget.orElseThrow());
    }
}
