package com.example.ecommerceplatform.ws;

import com.example.ecommerceplatform.ProductCategory;
import com.example.ecommerceplatform.model.Product;
import com.example.ecommerceplatform.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.jws.WebService;
import java.util.List;

@Service
@WebService(endpointInterface = "com.example.ecommerceplatform.ws.ProductServiceWS")
public class ProductServiceWSImpl implements ProductServiceWS {

    @Autowired
    private ProductService productService;

    @Override
    public String getProductDetails(Long id) {
        Product product = productService.findById(id).orElse(null);
        return product != null ? product.toString() : "Product not found";
    }

    @Override
    public String getAllProducts(Long id) {
        List<Product> product = productService.findAll();
        return product != null ? product.toString() : "No products found";
    }

    @Override
    public String getAllProductCategories() {
        ProductCategory[] categories = ProductCategory.values();
        return categories != null ? categories.toString() : "No product categories found";
    }

    public String getProductsByCategory(String category) {
        List<Product> productsInCategory = productService.getProductsByCategory(ProductCategory.valueOf(category));
        return productsInCategory != null ? productsInCategory.toString() : "No products found";
    }
}