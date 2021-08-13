package com.acdamatta.budgetcontrol.entity;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "expense_type")
@Data
public class ExpenseTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "type_name", length = 50)
    private String typeName;

    @ManyToOne
    @JoinColumn(name = "data_owner_id")
    private UserEntity dataOwner;

}
