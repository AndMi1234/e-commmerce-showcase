package com.example.ecommerceplatform.ws;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

@WebService
public interface ProductServiceWS {

    @WebMethod
    String getProductDetails(Long id);
    @WebMethod
    public String getAllProducts(Long id);
}