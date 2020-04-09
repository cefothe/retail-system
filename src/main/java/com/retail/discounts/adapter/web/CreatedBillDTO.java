package com.retail.discounts.adapter.web;

public class CreatedBillDTO {
    private String userId;
    private String billId;

    public CreatedBillDTO(String userId, String billId) {
        this.userId = userId;
        this.billId = billId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }
}
