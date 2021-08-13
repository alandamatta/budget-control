package com.acdamatta.budgetcontrol.service;

import com.acdamatta.budgetcontrol.entity.BudgetEntity;
import org.javamoney.moneta.Money;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BudgetServiceTest {

    @Autowired
    private BudgetService budgetService;

    @Test
    public void createAndFindTest() {
        BudgetEntity budgetEntity = new BudgetEntity();
        budgetEntity.setName("Budget Test");
        budgetEntity.setLimitValue(Money.of(50, "USD"));
        final BudgetEntity budgetEntity1 = budgetService.create(budgetEntity);

        assertNotNull(budgetEntity1);

        final Optional<BudgetEntity> byId = budgetService.findById(1L);

        assertTrue(byId.isPresent());

        assertEquals("USD 50.00", byId.get().getLimitValue().toString());
    }
}