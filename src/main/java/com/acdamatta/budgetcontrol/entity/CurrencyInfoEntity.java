package com.acdamatta.budgetcontrol.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "currency_info")
@Data
public class CurrencyInfoEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "iso_code")
    private String isoCode;

    private String symbol;

}
