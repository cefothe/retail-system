package com.retail.discounts.domain.bill;

import com.retail.discounts.domain.Money;
import com.retail.discounts.domain.product.Product;
import com.retail.discounts.domain.user.User;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Bill {
    private final String billId;
    private final User user;
    private final List<Product> products;

    private Bill(String billId, User user, List<Product> products) {
        this.billId = billId;
        this.user = user;
        this.products = products;
    }

    public static Bill create(String billId, User user){
        return new Bill(billId, user, new ArrayList<>());
    }
    public static Bill create(String billId, User user, List<Product> products){
        return new Bill(billId, user, products);
    }

    public boolean addProduct(Product product){
       return products.add(product);
    }

    public Money billTotal(){
        return products.stream()
           .map(product -> {
               if(Product.canApplyDiscount(product)){
                return product.getPrice()
                    .minus(Money.percentage(product.getPrice(),user.getDiscount()));
               }
               return product.getPrice();
           }).reduce(Money::add)
            .orElse(Money.ZERO);
    }

    public String getBillId() {
        return billId;
    }

    public User getUser() {
        return user;
    }

    public List<Product> getProducts() {
        return Collections.unmodifiableList(products);
    }
}
