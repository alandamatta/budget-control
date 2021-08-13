package com.acdamatta.budgetcontrol.controller;

import com.acdamatta.budgetcontrol.dto.ExpenseDTO;
import com.acdamatta.budgetcontrol.entity.ExpenseEntity;
import com.acdamatta.budgetcontrol.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/expense")
public class ExpenseController {

    private ExpenseService expenseService;

    @Autowired
    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @PostMapping
    public ResponseEntity<ExpenseDTO> create(@RequestBody ExpenseDTO expenseDTO) {
        final ExpenseEntity expense = expenseService.fromDTO(expenseDTO);
        expenseDTO = expenseService.toDTO(expenseService.create(expense));
        return ResponseEntity.ok(expenseDTO);
    }

    @GetMapping
    public ResponseEntity<List<ExpenseDTO>> get() {
        final List<ExpenseEntity> expenses = expenseService.findAll();
        final List<ExpenseDTO> expensesDTO = expenses.stream().map(expenseService::toDTO).collect(Collectors.toList());
        return ResponseEntity.ok(expensesDTO);
    }
}
