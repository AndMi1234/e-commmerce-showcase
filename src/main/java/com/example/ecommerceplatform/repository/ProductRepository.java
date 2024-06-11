package com.example.ecommerceplatform.repository;

import com.example.ecommerceplatform.ProductCategory;
import com.example.ecommerceplatform.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategory(ProductCategory category);
}
