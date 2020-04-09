package com.retail.discounts.domain.user;

public final class Affiliate extends User {

    private static final Double DISCOUNT = 0.1d;

    private Affiliate(String userId) {
        super(userId);
    }

    public static Affiliate of(String userId){
        return new Affiliate(userId);
    }

    @Override
    public double getDiscount() {
        return DISCOUNT;
    }

}
