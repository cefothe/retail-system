package com.retail.discounts.application.port.out;

import com.retail.discounts.domain.bill.Bill;

public interface UpdateBillPort {
    Bill updateBill(Bill bill);
}
