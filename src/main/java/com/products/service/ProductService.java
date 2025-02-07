package com.products.service;

import com.products.payloads.ProductDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    List<ProductDto> getAllProducts();

    ProductDto getProductById(Long id);

    ProductDto createProduct(ProductDto product);

    ProductDto updateProductById(Long id, ProductDto product);

    void deleteProductById(Long id);
}
