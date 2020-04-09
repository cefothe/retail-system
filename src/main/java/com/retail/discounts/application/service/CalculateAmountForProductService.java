package com.retail.discounts.application.service;

import com.retail.discounts.application.port.in.CalculateAmountForProductUseCase;
import com.retail.discounts.application.port.out.GetBillByIdPort;
import com.retail.discounts.domain.Money;
import org.springframework.stereotype.Service;

@Service
public class CalculateAmountForProductService implements CalculateAmountForProductUseCase {

    private final GetBillByIdPort getBillByIdPort;

    public CalculateAmountForProductService(
        GetBillByIdPort getBillByIdPort) {
        this.getBillByIdPort = getBillByIdPort;
    }

    @Override
    public Money calculate(CalculateCommand calculateCommand) {
        return getBillByIdPort.getBillById(calculateCommand.getBillId()).billTotal();
    }
}
