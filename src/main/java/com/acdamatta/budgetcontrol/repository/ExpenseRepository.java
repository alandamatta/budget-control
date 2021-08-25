package com.acdamatta.budgetcontrol.repository;

import com.acdamatta.budgetcontrol.entity.ExpenseEntity;
import com.acdamatta.budgetcontrol.projection.ExpenseInfo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ExpenseRepository extends CrudRepository<ExpenseEntity, Long> {

    @Query(name = "Expense.findAllWithCurrencySymbol", nativeQuery = true)
    List<ExpenseInfo> findAllWithCurrencySymbol();

}
