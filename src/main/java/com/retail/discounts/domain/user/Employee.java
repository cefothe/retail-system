package com.retail.discounts.domain.user;

public final class Employee extends User {

    private static final Double DISCOUNT = 0.3d;

    private Employee(String userId) {
        super(userId);
    }

    public static Employee of(String userId){
        return new Employee(userId);
    }

    @Override
    public double getDiscount() {
        return DISCOUNT;
    }
}
