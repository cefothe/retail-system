package com.retail.discounts.application.service;

import com.retail.discounts.application.port.in.CreateBillUseCase;
import com.retail.discounts.application.port.out.CreateBillPort;
import com.retail.discounts.domain.bill.Bill;
import org.springframework.stereotype.Service;

@Service
class CreateBillService implements CreateBillUseCase {

    private final CreateBillPort createBillPort;

    CreateBillService(CreateBillPort createBillPort) {
        this.createBillPort = createBillPort;
    }

    @Override
    public Bill createBill(CreateBillCommand createBillCommand) {
        return createBillPort.createBill(createBillCommand.getUserId());
    }
}
