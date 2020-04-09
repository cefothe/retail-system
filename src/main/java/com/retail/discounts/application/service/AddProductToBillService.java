package com.retail.discounts.application.service;

import com.retail.discounts.application.port.in.AddProductToBillUseCase;
import com.retail.discounts.application.port.out.UpdateBillPort;
import com.retail.discounts.application.port.out.GetBillByIdPort;
import com.retail.discounts.application.port.out.GetProductByIdPort;
import com.retail.discounts.domain.bill.Bill;
import org.springframework.stereotype.Service;

@Service
public class AddProductToBillService implements AddProductToBillUseCase {

    private final GetProductByIdPort getProductByIdPort;
    private final GetBillByIdPort getBillByIdPort;
    private final UpdateBillPort updateBillPort;

    public AddProductToBillService(
        GetProductByIdPort getProductByIdPort,
        GetBillByIdPort getBillByIdPort,
        UpdateBillPort updateBillPort) {
        this.getProductByIdPort = getProductByIdPort;
        this.getBillByIdPort = getBillByIdPort;
        this.updateBillPort = updateBillPort;
    }

    @Override
    public Bill addProductToBill(AddProductCommand addProductCommand) {
       var bill = getBillByIdPort.getBillById(addProductCommand.getBillId());
       var product = getProductByIdPort.getProductById(addProductCommand.getProductId());
       bill.addProduct(product);
       return updateBillPort.updateBill(bill);
    }
}
