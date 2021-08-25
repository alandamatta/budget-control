package com.acdamatta.budgetcontrol.controller;

import com.acdamatta.budgetcontrol.entity.BudgetEntity;
import com.acdamatta.budgetcontrol.entity.ExpenseTypeEntity;
import com.acdamatta.budgetcontrol.projection.BudgetInfo;
import com.acdamatta.budgetcontrol.projection.ExpenseInfo;
import com.acdamatta.budgetcontrol.service.BudgetService;
import com.acdamatta.budgetcontrol.service.ExpenseService;
import com.acdamatta.budgetcontrol.service.ExpenseTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

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
        final List<BudgetInfo> budgetsInfos = budgetService.findAllBudgetInfo();
        final List<ExpenseInfo> expenses = expenseService.findAllWithCurrencySymbol();
        final List<BudgetEntity> budgets = budgetService.findAll();
        final List<ExpenseTypeEntity> expenseTypes = expenseTypeService.findAll();


        model.addAttribute("budgets", budgetsInfos);
        model.addAttribute("expenses", expenses);
        model.addAttribute("budgetOptions", budgets);
        model.addAttribute("expenseTypes", expenseTypes);

        return "dashboard";
    }

    @PostMapping("/budget/delete")
    public String deleteBudgetById(Long budgetId) {
        budgetService.deleteById(budgetId);
        return "redirect:/dashboard";
    }

}
