package com.retail.discounts.application.port.in;

import com.retail.discounts.domain.bill.Bill;
import java.util.Objects;

public interface AddProductToBillUseCase {
    Bill addProductToBill(AddProductCommand addProductCommand);

    public class AddProductCommand{
        private final String billId;
        private final String productId;

        public AddProductCommand(String billId, String productId) {
            this.billId = billId;
            this.productId = productId;
        }

        public String getBillId() {
            return billId;
        }

        public String getProductId() {
            return productId;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            AddProductCommand that = (AddProductCommand) o;
            return Objects.equals(billId, that.billId) &&
                Objects.equals(productId, that.productId);
        }

        @Override
        public int hashCode() {
            return Objects.hash(billId, productId);
        }
    }
}
