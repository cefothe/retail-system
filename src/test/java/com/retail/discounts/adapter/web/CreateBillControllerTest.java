package com.retail.discounts.adapter.web;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.retail.discounts.application.port.in.CreateBillUseCase;
import com.retail.discounts.application.port.in.CreateBillUseCase.CreateBillCommand;
import com.retail.discounts.domain.bill.Bill;
import com.retail.discounts.domain.user.Customer;
import com.retail.discounts.domain.user.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(controllers = CreateBillController.class)
class CreateBillControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CreateBillUseCase createBillUseCase;

    @Test
    void createBillWithCorrectUser() throws Exception {
        //given
        var createBillCommand = new CreateBillCommand("123123");
        when(createBillUseCase.createBill(new CreateBillCommand("123123")))
            .thenReturn(Bill.create("132132", Customer.of("123123")));

        // when
        mvc.perform(post("/api/v1/bill")
            .header("Content-Type", "application/json")
            .content("{\"userId\": \"123123\"}"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("userId").value("123123"))
            .andExpect(jsonPath("billId").value("132132"));

        // then
        verify(createBillUseCase, times(1)).createBill(createBillCommand);
    }
}