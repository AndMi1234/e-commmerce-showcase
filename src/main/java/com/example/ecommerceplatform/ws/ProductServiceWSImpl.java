package com.example.ecommerceplatform.ws;

import com.example.ecommerceplatform.model.Product;
import com.example.ecommerceplatform.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.jws.WebService;

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
}