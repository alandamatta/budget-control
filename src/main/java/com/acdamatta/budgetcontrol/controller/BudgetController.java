package com.acdamatta.budgetcontrol.controller;

import com.acdamatta.budgetcontrol.entity.BudgetEntity;
import com.acdamatta.budgetcontrol.projection.BudgetInfo;
import com.acdamatta.budgetcontrol.service.BudgetService;
import com.acdamatta.budgetcontrol.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/budget")
public class BudgetController {

    private final BudgetService budgetService;

    private final SessionService sessionService;

    @Autowired
    public BudgetController(BudgetService budgetService,
                            SessionService sessionService) {
        this.budgetService = budgetService;
        this.sessionService = sessionService;
    }

    @PostMapping
    public String create(BudgetEntity budget) {
        budget.setDataOwner(sessionService.getLoggedUser());
        budgetService.create(budget);
        return "redirect:/settings";
    }

    @GetMapping("/info")
    public ResponseEntity<List<BudgetInfo>> allBudgetsInfo() {
        return ResponseEntity.ok(budgetService.findAllBudgetInfo());
    }

}
