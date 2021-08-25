package com.acdamatta.budgetcontrol.controller;

import com.acdamatta.budgetcontrol.entity.ExpenseEntity;
import com.acdamatta.budgetcontrol.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@Controller
@RequestMapping("/expense")
public class ExpenseController {

    private ExpenseService expenseService;

    @Autowired
    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @PostMapping("/api")
    public ResponseEntity<ExpenseEntity> create(@RequestBody ExpenseEntity expense) {
        expense = expenseService.create(expense);
        return ResponseEntity.ok(expense);
    }

    @PostMapping("/delete")
    public String delete(Long expenseId) {
        expenseService.deleteById(expenseId);
        return "redirect:/dashboard";
    }

    @PostMapping
    public String create2(ExpenseEntity expense) {
        expenseService.create(expense);
        return "redirect:/dashboard";
    }

    @GetMapping
    public ResponseEntity<List<ExpenseEntity>> get() {
        final List<ExpenseEntity> expenses = expenseService.findAll();
        return ResponseEntity.ok(expenses);
    }
}
