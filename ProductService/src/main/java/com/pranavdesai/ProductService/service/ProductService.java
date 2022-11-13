package com.pranavdesai.ProductService.service;

import com.pranavdesai.ProductService.model.ProductRequest;
import com.pranavdesai.ProductService.model.ProductResponse;

public interface ProductService {
    public long addProduct(ProductRequest productRequest);

    public ProductResponse getProduct(long productId);
}
