package com.retail.discounts.adapter.persistence;

import com.retail.discounts.domain.user.Affiliate;
import com.retail.discounts.domain.user.Customer;
import com.retail.discounts.domain.user.Employee;
import com.retail.discounts.domain.user.User;
import org.springframework.stereotype.Component;

@Component
class UserMapper {

    public User mapToDomainEntity(UserEntity userEntity) {
        switch (userEntity.getType()){
            case CUSTOMER:
                return Customer.of(userEntity.getId());
            case EMPLOYEE:
                return Employee.of(userEntity.getId());
            case AFFILIATE:
                return Affiliate.of(userEntity.getId());
            default:
                throw new RuntimeException("Unsupported type");
        }
    }
}
