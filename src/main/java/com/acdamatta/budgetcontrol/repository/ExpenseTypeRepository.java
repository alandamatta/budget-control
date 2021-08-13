package com.acdamatta.budgetcontrol.repository;

import com.acdamatta.budgetcontrol.entity.ExpenseTypeEntity;
import org.springframework.data.repository.CrudRepository;

public interface ExpenseTypeRepository extends CrudRepository<ExpenseTypeEntity, Long> {

}
