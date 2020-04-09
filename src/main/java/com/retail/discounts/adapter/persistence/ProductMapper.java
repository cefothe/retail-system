package com.retail.discounts.adapter.persistence;


import com.retail.discounts.adapter.persistence.ProductEntity.ProductType;
import com.retail.discounts.domain.Money;
import com.retail.discounts.domain.product.Product;
import com.retail.discounts.domain.product.Product.Type;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public Product mapToDomainEntity(ProductEntity productEntity) {
        productEntity.getProductType();
        return Product.create(productEntity.getId(), productTypeMapper(productEntity.getProductType()), Money
            .of(productEntity.getBigDecimal()));
    }

    private Type productTypeMapper(ProductType productType){
        if(productType == ProductType.ANY){
            return Type.ANY;
        }
        return Type.GROCERIES;
    }

    private ProductType productTypeMapperEntity(Type productType){
        if(productType == Type.ANY){
            return ProductType.ANY;
        }
        return ProductType.GROCERIES;
    }
}
