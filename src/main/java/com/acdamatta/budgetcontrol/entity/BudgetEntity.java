package com.acdamatta.budgetcontrol.entity;

import com.acdamatta.budgetcontrol.converter.MoneyConverter;
import lombok.Data;
import org.javamoney.moneta.Money;

import javax.persistence.*;

@Entity(name = "budget")
@Data
public class BudgetEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @Column(name = "limit_value")
    @Convert(converter = MoneyConverter.class)
    private Money limitValue;

    @ManyToOne
    @JoinColumn(name = "data_owner_id")
    private UserEntity dataOwner;

}
