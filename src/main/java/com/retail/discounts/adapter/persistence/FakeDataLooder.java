package com.retail.discounts.adapter.persistence;

import com.retail.discounts.adapter.persistence.ProductEntity.ProductType;
import com.retail.discounts.adapter.persistence.UserEntity.UserType;
import java.math.BigDecimal;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
class FakeDataLoader implements CommandLineRunner {

    private final static Logger LOGGER = LoggerFactory.getLogger(FakeDataLoader.class);

    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    FakeDataLoader(ProductRepository productRepository,
        UserRepository userRepository) {
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        LOGGER.info("Create Product Data");
        var productFirst = productRepository.save(new ProductEntity(UUID.randomUUID().toString(), ProductType.ANY,
            BigDecimal.valueOf(80d)));
        LOGGER.info("Product first {}", productFirst);
        var productSecond = productRepository.save(new ProductEntity(UUID.randomUUID().toString(), ProductType.GROCERIES,
            BigDecimal.valueOf(10d)));
        LOGGER.info("Product second {}", productSecond);
        var productThird = productRepository.save(new ProductEntity(UUID.randomUUID().toString(), ProductType.GROCERIES,
            BigDecimal.valueOf(10d)));
        LOGGER.info("Product third {}", productThird);

        LOGGER.info("Create USER data");
        var userFirst = userRepository.save(new UserEntity(UUID.randomUUID().toString(), UserType.AFFILIATE));
        LOGGER.info("User first {}", userFirst);
        var userSecond = userRepository.save(new UserEntity(UUID.randomUUID().toString(), UserType.CUSTOMER));
        LOGGER.info("User second {}", userSecond);
        var userThird = userRepository.save(new UserEntity(UUID.randomUUID().toString(), UserType.EMPLOYEE));
        LOGGER.info("User second {}", userThird);

    }
}
