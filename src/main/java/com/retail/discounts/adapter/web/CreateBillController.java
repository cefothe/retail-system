package com.retail.discounts.adapter.web;

import com.retail.discounts.application.port.in.CreateBillUseCase;
import com.retail.discounts.application.port.in.CreateBillUseCase.CreateBillCommand;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1")
@RestController
class CreateBillController {

    private final CreateBillUseCase createBillUseCase;

    CreateBillController(
        CreateBillUseCase createBillUseCase) {
        this.createBillUseCase = createBillUseCase;
    }

    @PostMapping("/bill")
    CreatedBillDTO createBill(@RequestBody CreateBillDTO createBillDto){
        var bill = createBillUseCase.createBill(new CreateBillCommand(createBillDto.getUserId()));
        return new CreatedBillDTO(bill.getUser().getId(), bill.getBillId());
    }

}

