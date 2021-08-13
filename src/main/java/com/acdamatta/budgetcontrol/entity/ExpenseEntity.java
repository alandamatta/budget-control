package com.acdamatta.budgetcontrol.entity;

import com.acdamatta.budgetcontrol.converter.MoneyConverter;
import lombok.Data;
import org.javamoney.moneta.Money;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "expense")
@Data
public class ExpenseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Convert(converter = MoneyConverter.class)
    private Money value;

    @ManyToOne
    @JoinColumn(name = "expense_type_id")
    private ExpenseTypeEntity expenseType;

    @ManyToOne
    @JoinColumn(name = "budget_id")
    private BudgetEntity budget;

    @Column(length = 60)
    private String name;

    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "data_owner_id")
    private UserEntity dataOwner;

}
