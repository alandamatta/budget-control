package com.acdamatta.budgetcontrol.controller;

import com.acdamatta.budgetcontrol.entity.ExpenseTypeEntity;
import com.acdamatta.budgetcontrol.service.ExpenseTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/expenseType")
public class ExpenseTypeController {

    private ExpenseTypeService expenseTypeService;

    @Autowired
    public ExpenseTypeController(ExpenseTypeService expenseTypeService) {
        this.expenseTypeService = expenseTypeService;
    }

    @PostMapping
    public ResponseEntity<ExpenseTypeEntity> create(@RequestBody ExpenseTypeEntity expenseType) {
        return ResponseEntity.ok(expenseTypeService.create(expenseType));
    }

}
