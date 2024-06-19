package com.example.ecommerceplatform.service;

import com.example.ecommerceplatform.model.ProductCategory;
import com.example.ecommerceplatform.repository.ProductCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductCategoryService {
    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    public List<ProductCategory> findAll() {
        return productCategoryRepository.findAll();
    }

    public ProductCategory save(ProductCategory category) {
        return productCategoryRepository.save(category);
    }

    public void deleteById(Long id) {
        productCategoryRepository.deleteById(id);
    }

    public Optional<ProductCategory> findById(Long id) {
        return productCategoryRepository.findById(id);
    }
}
