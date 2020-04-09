package com.retail.discounts.adapter.persistence;

import com.retail.discounts.application.port.out.UpdateBillPort;
import com.retail.discounts.application.port.out.CreateBillPort;
import com.retail.discounts.application.port.out.GetBillByIdPort;
import com.retail.discounts.application.port.out.GetProductByIdPort;
import com.retail.discounts.domain.bill.Bill;
import com.retail.discounts.domain.product.Product;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
class BillPersistenceAdapter implements CreateBillPort, GetProductByIdPort, GetBillByIdPort,
    UpdateBillPort {

    private final BillRepository billRepository;
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final ProductMapper productMapper;
    private final ProductRepository productRepository;

    public BillPersistenceAdapter(
        BillRepository billRepository,
        UserRepository userRepository,
        UserMapper userMapper, ProductMapper productMapper,
        ProductRepository productRepository) {
        this.billRepository = billRepository;
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.productMapper = productMapper;
        this.productRepository = productRepository;
    }

    @Override
    public Bill createBill(String userId) {
        UserEntity userEntity = userRepository.findById(userId)
            .orElseThrow(() -> new RuntimeException("User not found"));

        var billEntity = new BillEntity(UUID.randomUUID().toString(), userEntity);
        billRepository.save(billEntity);
        return Bill.create(billEntity.getId(),userMapper.mapToDomainEntity(userEntity));
    }

    @Override
    public Bill getBillById(String billId) {
        var billEntity = billRepository.findById(billId)
            .orElseThrow(() -> new RuntimeException("Bill not found"));
        var bill = Bill.create(billId,userMapper.mapToDomainEntity(billEntity.getUser()));
        billEntity.getProducts()
            .forEach(productEntity -> bill.addProduct(productMapper.mapToDomainEntity(productEntity)));
        return bill;
    }

    @Override
    public Product getProductById(String productId) {
        var productEntity = productRepository.findById(productId)
            .orElseThrow(() -> new RuntimeException("Product not found"));
        return productMapper.mapToDomainEntity(productEntity);
    }

    @Override
    public Bill updateBill(Bill bill) {
        var billEntity = billRepository.findById(bill.getBillId())
            .orElseThrow(() -> new RuntimeException("Bill not found"));
        billEntity.getProducts().clear();
        var productEntities = bill.getProducts()
            .stream()
            .map(product -> productRepository.getOne(product.getProductId()))
            .collect(Collectors.toList());
        billEntity.setProducts(productEntities);
        billRepository.save(billEntity);
        return bill;
    }
}
