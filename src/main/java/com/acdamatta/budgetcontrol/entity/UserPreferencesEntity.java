package com.acdamatta.budgetcontrol.entity;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "user_preferences")
@Data
public class UserPreferencesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String currency;

    @ManyToOne
    @JoinColumn(name = "currency_info_id")
    private CurrencyInfoEntity currencyInfo;

    @ManyToOne
    @JoinColumn(name = "data_owner_id")
    private UserEntity dataOwner;

}
