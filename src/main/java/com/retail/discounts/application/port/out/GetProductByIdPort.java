package com.retail.discounts.application.port.out;

import com.retail.discounts.domain.product.Product;

public interface GetProductByIdPort {
    Product getProductById(String productId);
}
