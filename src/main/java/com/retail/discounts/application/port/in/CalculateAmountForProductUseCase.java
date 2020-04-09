package com.retail.discounts.application.port.in;

import com.retail.discounts.domain.Money;

public interface CalculateAmountForProductUseCase {
    Money calculate(CalculateCommand calculateCommand);

    public class CalculateCommand{
        private String billId;

        public CalculateCommand(String billId) {
            this.billId = billId;
        }

        public String getBillId() {
            return billId;
        }

        public void setBillId(String billId) {
            this.billId = billId;
        }
    }
}
