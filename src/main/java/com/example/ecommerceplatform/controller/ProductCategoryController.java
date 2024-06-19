package com.example.ecommerceplatform.controller;

import com.example.ecommerceplatform.model.ProductCategory;
import com.example.ecommerceplatform.service.ProductCategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductCategoryController {

    @Autowired
    private ProductCategoryService productCategoryService;

    @GetMapping
    public List<ProductCategory> getAllProductCategories() {
        return productCategoryService.findAll();
    }

    @GetMapping("/{id}")
    public ProductCategory getProductCategoryById(@PathVariable Long id) {
        return productCategoryService.findById(id).orElse(null);
    }

    @PostMapping
    public ProductCategory createProductCategory(@RequestBody ProductCategory product) {
        return productCategoryService.save(product);
    }

    @PutMapping("/{id}")
    public ProductCategory updateProduct(@PathVariable Long id, @RequestBody ProductCategory product) {
        product.setId(id);
        return productCategoryService.save(product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productCategoryService.deleteById(id);
    }
}
