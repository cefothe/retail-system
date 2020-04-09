package com.retail.discounts.adapter.web;

import com.retail.discounts.application.port.in.CalculateAmountForProductUseCase;
import com.retail.discounts.application.port.in.CalculateAmountForProductUseCase.CalculateCommand;
import com.retail.discounts.domain.Money;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1")
@RestController
class CalculateBillController {

    private final CalculateAmountForProductUseCase calculateAmountForProductUseCase;

    CalculateBillController(
        CalculateAmountForProductUseCase calculateAmountForProductUseCase) {
        this.calculateAmountForProductUseCase = calculateAmountForProductUseCase;
    }

    @GetMapping("/bill/{billId}")
    BillAmountDTO calculate(@PathVariable("billId") String billId){
        Money money = calculateAmountForProductUseCase.calculate(new CalculateCommand(billId));
        return new BillAmountDTO(billId, money.getAmount().toPlainString());
    }

}
