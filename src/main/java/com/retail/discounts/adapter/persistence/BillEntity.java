package com.retail.discounts.adapter.persistence;

import com.retail.discounts.common.BaseEntity;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
class BillEntity extends BaseEntity {

    @OneToOne
    private UserEntity user;

    @OneToMany(fetch = FetchType.EAGER)
    private List<ProductEntity> products;

    public BillEntity(String id, UserEntity user) {
        super(id);
        this.user = user;
        this.products = new ArrayList<>();
    }

    public BillEntity(){
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public List<ProductEntity> getProducts() {
        return products;
    }

    public void setProducts(List<ProductEntity> products) {
        this.products = products;
    }
}
