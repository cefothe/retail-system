package com.retail.discounts.common;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseEntity {

    @Id
    private String id;

    public BaseEntity(String id) {
        this.id = id;
    }

    public BaseEntity() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "BaseEntity{" +
            "id='" + id + '\'' +
            '}';
    }
}
