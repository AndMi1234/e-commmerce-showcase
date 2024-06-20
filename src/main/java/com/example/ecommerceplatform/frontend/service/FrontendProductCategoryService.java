package com.example.ecommerceplatform.frontend.service;

import com.example.ecommerceplatform.model.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class FrontendProductCategoryService {

    private static final String BASE_URL = "http://localhost:8080/products";

    @Autowired
    private RestTemplate restTemplate;

    public List<ProductCategory> getAllProductCategories() {
        return Arrays.asList(restTemplate.getForObject(BASE_URL, ProductCategory[].class));
    }

    public ProductCategory getProductCategoryById(Long id) {
        return restTemplate.getForObject(BASE_URL + "/" + id, ProductCategory.class);
    }

    public ProductCategory createProductCategory(ProductCategory productCategory) {
        return restTemplate.postForObject(BASE_URL, productCategory, ProductCategory.class);
    }

    public ProductCategory updateProductCategory(Long id, ProductCategory productCategory) {
        restTemplate.put(BASE_URL + "/" + id, productCategory);
        return productCategory;
    }

    public void deleteProductCategory(Long id) {
        restTemplate.delete(BASE_URL + "/" + id);
    }
}
