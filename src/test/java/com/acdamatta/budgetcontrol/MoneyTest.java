package com.acdamatta.budgetcontrol;

import org.javamoney.moneta.Money;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.money.MonetaryAmount;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class MoneyTest {

    @Test
    public void test() {
        List<MonetaryAmount> amounts = new ArrayList<>();
        amounts.add(Money.of(33.33, "USD"));
        amounts.add(Money.of(50, "USD"));
        amounts.add(Money.of(1.33, "USD"));

        Money sum = Money.of(0, "USD");

        for (MonetaryAmount amount : amounts) {
            sum = sum.add(amount);
        }

        Assertions.assertEquals("USD 84.66", sum.toString());
    }

}
