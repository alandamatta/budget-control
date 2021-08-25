package com.acdamatta.budgetcontrol.entity;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "budget")
@Data
public class BudgetEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @Column(name = "limit_value")
    private double limitValue;

    @ManyToOne
    @JoinColumn(name = "data_owner_id")
    private UserEntity dataOwner;

}
