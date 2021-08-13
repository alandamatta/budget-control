package com.acdamatta.budgetcontrol.repository;

import com.acdamatta.budgetcontrol.entity.BudgetEntity;
import com.acdamatta.budgetcontrol.view.BudgetInfoView;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BudgetRepository extends CrudRepository<BudgetEntity, Long> {

    @Query(value = "select b.id, cast(b.limit_value as decimal) as limitValue, b.name as budgetName, " +
            "sum(cast(e.value as decimal)) as totalExpenses from budget b " +
            "inner join expense e on e.budget_id = b.id group by 1;" , nativeQuery = true)
    List<BudgetInfoView> getAllBudgetsInfo();

}
