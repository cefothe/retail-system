package com.retail.discounts.application.port.out;

import com.retail.discounts.domain.bill.Bill;

public interface GetBillByIdPort {
    Bill getBillById(String billId);
}
