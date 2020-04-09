package com.retail.discounts.application.port.in;

import com.retail.discounts.domain.bill.Bill;
import java.util.Objects;

public interface CreateBillUseCase {

    Bill createBill(CreateBillCommand createBillCommand);

    class CreateBillCommand {
        private final String userId;

        public CreateBillCommand(String userId) {
            this.userId = userId;
        }

        public String getUserId() {
            return userId;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            CreateBillCommand that = (CreateBillCommand) o;
            return Objects.equals(userId, that.userId);
        }

        @Override
        public int hashCode() {
            return Objects.hash(userId);
        }
    }
}
