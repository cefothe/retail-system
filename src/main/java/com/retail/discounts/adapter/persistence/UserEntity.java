package com.retail.discounts.adapter.persistence;

import com.retail.discounts.common.BaseEntity;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
class UserEntity extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private UserType type;

    public UserEntity(String id, UserType userType) {
        super(id);
        this.type = userType;
    }

    public UserEntity(){
    }

    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
            "type=" + type +
            "} " + super.toString();
    }

    enum UserType{ CUSTOMER, EMPLOYEE, AFFILIATE}
}
