package com.codebygaurav.jpatuttorial;

import com.codebygaurav.jpatuttorial.entities.ProductEntity;
import com.codebygaurav.jpatuttorial.reposities.ProductRespository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class JpatuttorialApplicationTests {

    @Autowired
    ProductRespository productRespository;

	@Test
	void contextLoads() {
	}

    @Test
    void testRepository(){
        ProductEntity productEntity = ProductEntity.builder()
                .sku("nestle12")
                .title("Nestle chocoloate")
                .price(BigDecimal.valueOf(123.32))
                .quantity(4)
                .build();

        ProductEntity saveProductEntity = productRespository.save(productEntity);
        System.out.println(saveProductEntity);
    }


    @Test
    void getRepository(){
//        List<ProductEntity> entityList = productRespository.findByCreatedAtAfter(LocalDateTime.of(2024,1,1,0,0,0));

//        List<ProductEntity> entityList = productRespository.findByQuantityAndPrice(4, BigDecimal.valueOf(123.32));
        List<ProductEntity> entityList = productRespository.findByTitleContainingIgnoreCase("pepsi");
        System.out.println(entityList);
    }


    @Test
    void getSingleFromRepository(){
        Optional<ProductEntity> productEntity = productRespository.findByTitleAndPrice("pepsi", BigDecimal.valueOf(12.4));
        productEntity.ifPresent(System.out::println);
    }

}
