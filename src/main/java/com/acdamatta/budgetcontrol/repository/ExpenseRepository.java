package com.acdamatta.budgetcontrol.repository;

import com.acdamatta.budgetcontrol.entity.ExpenseEntity;
import org.springframework.data.repository.CrudRepository;

public interface ExpenseRepository extends CrudRepository<ExpenseEntity, Long> {

}
