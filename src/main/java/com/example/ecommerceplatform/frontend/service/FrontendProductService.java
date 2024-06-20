package com.example.ecommerceplatform.frontend.service;

import com.example.ecommerceplatform.model.Product;
import com.example.ecommerceplatform.model.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class FrontendProductService {

    private static final String BASE_URL = "http://localhost:8080/products";

    @Autowired
    private RestTemplate restTemplate;

    public List<Product> getAllProducts() {
        return Arrays.asList(restTemplate.getForObject(BASE_URL, Product[].class));
    }

    public List<Product> getProductsByCategory(ProductCategory category) {
        return Arrays.asList(restTemplate.getForObject(BASE_URL + "/category/" + category.getId(), Product[].class));
    }

    public Product getProductById(Long id) {
        return restTemplate.getForObject(BASE_URL + "/" + id, Product.class);
    }

    public Product createProduct(Product product) {
        return restTemplate.postForObject(BASE_URL, product, Product.class);
    }

    public Product updateProduct(Long id, Product product) {
        restTemplate.put(BASE_URL + "/" + id, product);
        return product;
    }

    public void deleteProduct(Long id) {
        restTemplate.delete(BASE_URL + "/" + id);
    }
}
