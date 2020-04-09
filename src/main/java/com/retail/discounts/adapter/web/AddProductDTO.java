package com.retail.discounts.adapter.web;

public class AddProductDTO {

    private String productId;

    public AddProductDTO() {
    }

    public AddProductDTO(String productId) {
        this.productId = productId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }
}
