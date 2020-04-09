package com.retail.discounts.adapter.persistence;

import com.retail.discounts.common.BaseEntity;
import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class ProductEntity extends BaseEntity {
    @Enumerated(EnumType.STRING)
    private ProductType productType;
    private BigDecimal bigDecimal;

    public ProductEntity(String id,
        ProductType productType, BigDecimal bigDecimal) {
        super(id);
        this.productType = productType;
        this.bigDecimal = bigDecimal;
    }
    public ProductEntity(){}

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(
        ProductType productType) {
        this.productType = productType;
    }

    public BigDecimal getBigDecimal() {
        return bigDecimal;
    }

    public void setBigDecimal(BigDecimal bigDecimal) {
        this.bigDecimal = bigDecimal;
    }

    @Override
    public String toString() {
        return "ProductEntity{" +
            "productType=" + productType +
            ", bigDecimal=" + bigDecimal +
            "} " + super.toString();
    }

    public enum ProductType{ GROCERIES, ANY}
}
