package com.acdamatta.budgetcontrol.controller;

import com.acdamatta.budgetcontrol.dto.BudgetDTO;
import com.acdamatta.budgetcontrol.entity.BudgetEntity;
import com.acdamatta.budgetcontrol.entity.ExpenseEntity;
import com.acdamatta.budgetcontrol.entity.ExpenseTypeEntity;
import com.acdamatta.budgetcontrol.service.BudgetService;
import com.acdamatta.budgetcontrol.service.ExpenseService;
import com.acdamatta.budgetcontrol.service.ExpenseTypeService;
import com.acdamatta.budgetcontrol.view.BudgetInfoView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {

    private final BudgetService budgetService;

    private final ExpenseService expenseService;

    private final ExpenseTypeService expenseTypeService;


    @Autowired
    public DashboardController(BudgetService budgetService,
                               ExpenseService expenseService,
                               ExpenseTypeService expenseTypeService) {
        this.budgetService = budgetService;
        this.expenseService = expenseService;
        this.expenseTypeService = expenseTypeService;
    }

    @GetMapping
    public String render(Model model) {
        final List<BudgetInfoView> budgetsInfos = budgetService.findAllBudgetInfo();
        final List<ExpenseEntity> expenses = expenseService.findAll();
        final List<BudgetEntity> budgets = budgetService.findAll();
        final List<BudgetDTO> budgetDTOList = budgets.stream().map(budgetService::toDTO).collect(Collectors.toList());
        final List<ExpenseTypeEntity> expenseTypes = expenseTypeService.findAll();


        model.addAttribute("budgets", budgetsInfos);
        model.addAttribute("expenses", expenses);
        model.addAttribute("budgetOptions", budgetDTOList);
        model.addAttribute("expenseTypes", expenseTypes);

        return "dashboard";
    }

}
