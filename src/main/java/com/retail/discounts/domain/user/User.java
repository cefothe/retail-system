package com.retail.discounts.domain.user;

import java.util.Optional;

public abstract class User {

    public static final Double DEFAULT_DISCOUNT = 0d;

    private String userId;

    protected User(String userId){
        this.userId = userId;
    }

    public String getId() {
        return this.userId;
    }

    public abstract double getDiscount();
}
