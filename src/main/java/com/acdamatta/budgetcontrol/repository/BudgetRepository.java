package com.acdamatta.budgetcontrol.repository;

import com.acdamatta.budgetcontrol.entity.BudgetEntity;
import com.acdamatta.budgetcontrol.projection.BudgetInfo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BudgetRepository extends CrudRepository<BudgetEntity, Long> {

    @Query(name = "Budget.getAllBudgetsInfo" , nativeQuery = true)
    List<BudgetInfo> getAllBudgetsInfo();

}
