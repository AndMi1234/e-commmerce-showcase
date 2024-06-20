package com.example.ecommerceplatform.frontend.service;
import com.example.ecommerceplatform.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class FrontendCustomerService {

    private static final String BASE_URL = "http://localhost:8080/customers";

    @Autowired
    private RestTemplate restTemplate;

    public List<Customer> getAllCustomers() {
        return Arrays.asList(restTemplate.getForObject(BASE_URL, Customer[].class));
    }

    public Customer getCustomerById(Long id) {
        return restTemplate.getForObject(BASE_URL + "/" + id, Customer.class);
    }

    public Customer createCustomer(Customer customer) {
        return restTemplate.postForObject(BASE_URL, customer, Customer.class);
    }

    public Customer updateCustomer(Long id, Customer customer) {
        restTemplate.put(BASE_URL + "/" + id, customer);
        return customer;
    }

    public void deleteCustomer(Long id) {
        restTemplate.delete(BASE_URL + "/" + id);
    }
}
