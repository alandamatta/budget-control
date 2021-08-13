package com.acdamatta.budgetcontrol.controller;

import com.acdamatta.budgetcontrol.dto.BudgetDTO;
import com.acdamatta.budgetcontrol.entity.BudgetEntity;
import com.acdamatta.budgetcontrol.service.BudgetService;
import com.acdamatta.budgetcontrol.service.UserPreferencesService;
import com.acdamatta.budgetcontrol.view.BudgetInfoView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/budget")
public class BudgetController {

    private final BudgetService budgetService;

    private final UserPreferencesService userPreferencesService;

    @Autowired
    public BudgetController(BudgetService budgetService,
                            UserPreferencesService userPreferencesService) {
        this.budgetService = budgetService;
        this.userPreferencesService = userPreferencesService;
    }

    @PostMapping
    public ResponseEntity<BudgetDTO> create(@RequestBody BudgetDTO budgetDTO) {
        BudgetEntity budgetEntity = budgetService.fromDTO(budgetDTO);
        budgetEntity = budgetService.create(budgetEntity);
        budgetDTO = budgetService.toDTO(budgetEntity);
        return ResponseEntity.ok(budgetDTO);
    }

    @GetMapping("/info")
    public ResponseEntity<List<BudgetInfoView>> allBudgetsInfo() {
        return ResponseEntity.ok(budgetService.findAllBudgetInfo());
    }

}
