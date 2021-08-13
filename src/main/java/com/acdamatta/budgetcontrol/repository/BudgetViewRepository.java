package com.acdamatta.budgetcontrol.repository;

import com.acdamatta.budgetcontrol.view.BudgetInfoView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class BudgetViewRepository {

    private final EntityManager entityManager;

    @Autowired
    public BudgetViewRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<BudgetInfoView> findAll() {
        final Query namedQuery = entityManager.createNativeQuery(
                "select b.id, cast(b.limit_value as decimal) as limitValue, b.name as budgetName, " +
                "sum(cast(e.value as decimal)) as totalExpenses from budget b " +
                "inner join expense e on e.expense_type_id = b.expense_type_id group by 1;", BudgetInfoView.class);
        return namedQuery.getResultList();
    }
}
