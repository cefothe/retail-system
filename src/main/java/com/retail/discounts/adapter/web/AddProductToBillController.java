package com.retail.discounts.adapter.web;

import com.retail.discounts.application.port.in.AddProductToBillUseCase;
import com.retail.discounts.application.port.in.AddProductToBillUseCase.AddProductCommand;
import com.retail.discounts.application.port.in.CreateBillUseCase.CreateBillCommand;
import com.retail.discounts.domain.bill.Bill;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1")
@RestController
class AddProductToBillController {

    private final AddProductToBillUseCase addProductToBillUseCase;

    AddProductToBillController(
        AddProductToBillUseCase addProductToBillUseCase) {
        this.addProductToBillUseCase = addProductToBillUseCase;
    }

    @PostMapping("/bill/{billId}")
    Bill createBill(@PathVariable("billId") String billId, @RequestBody AddProductDTO addProductDTO){
       return addProductToBillUseCase.addProductToBill(new AddProductCommand(billId, addProductDTO.getProductId()));
    }
}
