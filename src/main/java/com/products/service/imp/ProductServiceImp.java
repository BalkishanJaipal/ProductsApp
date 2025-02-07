package com.products.service.imp;

import com.products.exception.ResourceNotFoundException;
import com.products.model.Product;
import com.products.payloads.ProductDto;
import com.products.repositories.ProductRepo;
import com.products.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductServiceImp implements ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> products = productRepo.findAll();
        return products.stream()
                .map(product -> modelMapper.map(product,ProductDto.class)).toList();
    }

    @Override
    public ProductDto getProductById(Long id) {
        Product product = productRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Product","id",id));
        return modelMapper.map(product,ProductDto.class);
    }

    @Override
    public ProductDto createProduct(ProductDto product) {
        Product product1 = modelMapper.map(product,Product.class);
        productRepo.save(product1);
        return modelMapper.map(product1,ProductDto.class);
    }

    @Override
    public ProductDto updateProductById(Long id, ProductDto productDto) {
        Product product = productRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Product","id",id));
        product.setDescription(productDto.getDescription());
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        productRepo.save(product);
        return modelMapper.map(product,ProductDto.class);

    }

    @Override
    public void deleteProductById(Long id) {
        Product product = productRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Product","id",id));
        productRepo.delete(product);
    }
}
