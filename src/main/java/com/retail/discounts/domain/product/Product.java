package com.retail.discounts.domain.product;

import com.retail.discounts.domain.Money;
import javax.validation.constraints.NotNull;

public final class Product {

    @NotNull
    private final String productId;
    @NotNull
    private final Type productType;
    @NotNull
    private final Money price;

    private Product(String productId, Type productType, Money price) {
        this.productId = productId;
        this.productType = productType;
        this.price = price;
    }

    public Money getPrice() {
        return price;
    }

    public String getProductId() {
        return productId;
    }

    public static Product create(String productId, Type productType, Money price){
        return new Product(productId, productType, price);
    }

    public static boolean canApplyDiscount(Product product){
        return product.productType != Type.GROCERIES;
    }

    public enum Type{ GROCERIES, ANY}
}
