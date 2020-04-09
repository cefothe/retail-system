package com.retail.discounts.domain.bill;

import static com.retail.discounts.domain.product.Product.Type.ANY;
import static com.retail.discounts.domain.product.Product.Type.GROCERIES;
import static org.junit.jupiter.api.Assertions.*;

import com.retail.discounts.domain.Money;
import com.retail.discounts.domain.product.Product;
import com.retail.discounts.domain.user.Affiliate;
import com.retail.discounts.domain.user.Customer;
import com.retail.discounts.domain.user.Employee;
import java.time.LocalDate;
import java.util.UUID;
import org.junit.jupiter.api.Test;

class BillTest {

    @Test
    public void billTestWithProductsTypeAnyNewCustomer(){
        // given
        var bill = Bill.create(generate(),Customer.of(generate()));
        bill.addProduct(Product.create(generate(),ANY, Money.of(5d)));
        bill.addProduct(Product.create(generate(),ANY, Money.of(5d)));
        // when
        var result = bill.billTotal();
        // then
        assertEquals(Money.of(10d), result, "calculation for bill total is not correct");
    }

    @Test
    public void billTestWithProductsTypeAnyCustomerOf3year(){
        // given
        var bill = Bill.create(generate(), Customer.of(generate(), LocalDate.now().minusYears(3)));
        bill.addProduct(Product.create(generate(),ANY, Money.of(5d)));
        bill.addProduct(Product.create(generate(),ANY, Money.of(5d)));
        // when
        var result = bill.billTotal();
        // then
        assertEquals(Money.of(8d), result, "calculation for bill total is not correct");
    }

    @Test
    public void billTestWithProductsTypeAnyEmployee(){
        // given
        var bill = Bill.create(generate(), Employee.of(generate()));
        bill.addProduct(Product.create(generate(),ANY, Money.of(5d)));
        bill.addProduct(Product.create(generate(),ANY, Money.of(5d)));
        // when
        var result = bill.billTotal();
        // then
        assertEquals(Money.of(7d), result, "calculation for bill total is not correct");
    }

    @Test
    public void billTestWithProductsTypeAnyAffiliate(){
        // given
        var bill = Bill.create(generate(), Affiliate.of(generate()));
        bill.addProduct(Product.create(generate(),ANY, Money.of(5d)));
        bill.addProduct(Product.create(generate(),ANY, Money.of(5d)));
        // when
        var result = bill.billTotal();
        // then
        assertEquals(Money.of(9d), result, "calculation for bill total is not correct");
    }

    @Test
    public void billTestWithProductsTypeGROCERIESAffiliate(){
        // given
        var bill = Bill.create(generate(), Affiliate.of(generate()));
        bill.addProduct(Product.create(generate(),ANY, Money.of(10d)));
        bill.addProduct(Product.create(generate(), GROCERIES, Money.of(10d)));
        // when
        var result = bill.billTotal();
        // then
        assertEquals(Money.of(19d), result, "calculation for bill total is not correct");
    }


    private String generate(){
        return UUID.randomUUID().toString();
    }
}