package com.retail.discounts.domain.user;

import java.time.LocalDate;

public final class Customer extends User {

    private static final Double DISCOUNT = 0.2d;

    private final LocalDate createdAt;

    private Customer(String userId, LocalDate createdAt) {
        super(userId);
        this.createdAt = createdAt;
    }

    public static Customer of(String userId){
        return new Customer(userId, LocalDate.now());
    }

    public static Customer of(String userId, LocalDate localDate){
        return new Customer(userId, localDate);
    }

    @Override
    public double getDiscount() {
        if(createdAt.plusYears(2).isBefore(LocalDate.now())){
            return DISCOUNT;
        }
        return DEFAULT_DISCOUNT;
    }
}
