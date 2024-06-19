package com.example.ecommerceplatform.ws;

import com.example.ecommerceplatform.model.ProductCategory;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

@WebService
public interface ProductServiceWS {

    @WebMethod
    String getProductDetails(Long id);
    @WebMethod
    public String getAllProducts(Long id);
    @WebMethod
    public String getAllProductCategories();
    @WebMethod
    public String getProductsByCategory(ProductCategory category);
}