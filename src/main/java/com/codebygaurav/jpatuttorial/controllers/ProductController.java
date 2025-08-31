package com.codebygaurav.jpatuttorial.controllers;

import com.codebygaurav.jpatuttorial.entities.ProductEntity;
import com.codebygaurav.jpatuttorial.reposities.ProductRespository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/products")
public class ProductController {

    private final int PAGE_SIZE = 5;
    private final ProductRespository productRespository;

    public ProductController(ProductRespository productRespository) {
        this.productRespository = productRespository;
    }

    @GetMapping
    public List<ProductEntity> getAllProducts(
            @RequestParam(defaultValue = "") String title,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "0") Integer pageNumber){

            return productRespository.findByTitleContainingIgnoreCase(
                    title,
                    PageRequest.of(pageNumber,PAGE_SIZE,Sort.by(sortBy))
            );

//        return productRespository.findBy(Sort.by(Sort.Direction.DESC,sortBy,"price"));
//        return productRespository.findBy(Sort.by(
//                Sort.Order.desc(sortBy),
//                Sort.Order.desc("title")
//                ));

//        Pageable pageable = PageRequest.of(
//                    pageNumber,
//                    PAGE_SIZE,
//                    Sort.by(sortBy)
//                );
//
//        return productRespository.findAll(pageable).getContent();

    }

}
