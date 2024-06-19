package com.example.ecommerceplatform.repository;

import com.example.ecommerceplatform.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findAllCustomers();
    Customer findCustomerById(Long id);
}
