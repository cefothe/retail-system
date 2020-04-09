package com.retail.discounts;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class RetailConfiguration {

    @Bean
    public Docket docker() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("public-api")
            .select().paths(PathSelectors.any()).build();
    }

}
