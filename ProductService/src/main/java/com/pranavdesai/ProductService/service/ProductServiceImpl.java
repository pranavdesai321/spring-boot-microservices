package com.pranavdesai.ProductService.service;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.pranavdesai.ProductService.entity.Product;
import com.pranavdesai.ProductService.exception.ProductServiceCustomException;
import com.pranavdesai.ProductService.model.ProductRequest;
import com.pranavdesai.ProductService.model.ProductResponse;
import com.pranavdesai.ProductService.respository.ProductRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;
    @Override
    public long addProduct(ProductRequest productRequest) {
        log.info("Adding Product..");

        Product product = Product.builder()
                .productName(productRequest.getName())
                .quantity(productRequest.getQuantity())
                .price(productRequest.getPrice())
                .build();
        productRepository.save(product);

        log.info("Product created!!");
        return product.getProductId();
    }

    @Override
    public ProductResponse getProduct(long productId) {
        log.info("Getting Product..");

        Product product = productRepository.findById(productId).orElseThrow(() -> new ProductServiceCustomException("Product with given id not found", "PRODUCT_NOT_FOUND"));

        ProductResponse productResponse = new ProductResponse();
        BeanUtils.copyProperties(product, productResponse);
        return productResponse;
    }
}
