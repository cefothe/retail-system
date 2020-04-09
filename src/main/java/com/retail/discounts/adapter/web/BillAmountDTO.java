package com.retail.discounts.adapter.web;

public class BillAmountDTO {
    private String billId;
    private String amount;

    public BillAmountDTO(String billId, String amount) {
        this.billId = billId;
        this.amount = amount;
    }

    public String getBillId() {
        return billId;
    }

    public String getAmount() {
        return amount;
    }
}
