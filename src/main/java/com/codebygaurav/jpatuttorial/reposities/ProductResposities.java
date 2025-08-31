package com.codebygaurav.jpatuttorial.reposities;

import com.codebygaurav.jpatuttorial.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductResposities extends JpaRepository<ProductEntity, Long> {
}
