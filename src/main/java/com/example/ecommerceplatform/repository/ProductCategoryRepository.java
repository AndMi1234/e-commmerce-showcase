package com.example.ecommerceplatform.repository;

import com.example.ecommerceplatform.model.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {
}
