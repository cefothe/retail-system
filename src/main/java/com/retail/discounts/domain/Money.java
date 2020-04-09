package com.retail.discounts.domain;

import java.math.BigDecimal;
import java.util.Objects;

public final class Money {

    public static final Money ZERO = Money.of(0d);

    private final BigDecimal amount;

    private Money(BigDecimal amount) {
        this.amount = amount.stripTrailingZeros();
    }

    public Money minus(Money money){
        return new Money(this.amount.subtract(money.amount));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Money money = (Money) o;
        return amount.equals(money.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }

    @Override
    public String toString() {
        return "Money{" +
            "amount=" + amount.toPlainString() +
            '}';
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public static Money of(long value) {
        return new Money(BigDecimal.valueOf(value));
    }

    public static Money of(double value) {
        return new Money(BigDecimal.valueOf(value));
    }
    public static Money of(BigDecimal value) { return new Money(value); }

    public static Money percentage(Money money, Double percentage){
        return new Money(money.amount.multiply(BigDecimal.valueOf(percentage)));
    }

    public static Money add(Money a, Money b) {
        return new Money(a.amount.add(b.amount));
    }

}
