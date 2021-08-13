package com.acdamatta.budgetcontrol.service;

import com.acdamatta.budgetcontrol.dto.BudgetDTO;
import com.acdamatta.budgetcontrol.entity.BudgetEntity;
import com.acdamatta.budgetcontrol.entity.ExpenseTypeEntity;
import com.acdamatta.budgetcontrol.repository.BudgetRepository;
import com.acdamatta.budgetcontrol.repository.BudgetViewRepository;
import com.acdamatta.budgetcontrol.view.BudgetInfoView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BudgetService {

    private final BudgetRepository budgetRepository;

    private final ExpenseTypeService expenseTypeService;

    private final MoneyService moneyService;

    private final BudgetViewRepository budgetViewRepository;

    @Autowired
    public BudgetService(BudgetRepository budgetRepository,
                         ExpenseTypeService expenseTypeService,
                         MoneyService moneyService,
                         BudgetViewRepository budgetViewRepository) {
        this.budgetRepository = budgetRepository;
        this.expenseTypeService = expenseTypeService;
        this.moneyService = moneyService;
        this.budgetViewRepository = budgetViewRepository;
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

    public List<BudgetInfoView> findAllBudgetInfo() {
        return budgetRepository.getAllBudgetsInfo();
    }

    public BudgetDTO toDTO(BudgetEntity budget) {
        BudgetDTO budgetDTO = BudgetDTO.newInstance();
        return budgetDTO.fromEntity(budget);
    }

    public BudgetEntity fromDTO(BudgetDTO budgetDTO) {
        BudgetEntity budget = new BudgetEntity();
        budget.setName(budgetDTO.getName());
        budget.setLimitValue(moneyService.toMoney(budgetDTO.getLimitValue()));
        return budget;
    }

}
