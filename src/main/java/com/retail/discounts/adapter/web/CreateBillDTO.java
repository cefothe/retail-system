package com.retail.discounts.adapter.web;

public class CreateBillDTO {
    private String userId;

    public CreateBillDTO(String userId) {
        this.userId = userId;
    }

    public CreateBillDTO() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
