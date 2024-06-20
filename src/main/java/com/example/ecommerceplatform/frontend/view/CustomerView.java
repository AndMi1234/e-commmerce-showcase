package com.example.ecommerceplatform.frontend.view;

import com.example.ecommerceplatform.frontend.service.FrontendCustomerService;
import com.example.ecommerceplatform.model.Customer;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route("customers")
public class CustomerView extends VerticalLayout {

    private final FrontendCustomerService customerService;
    private final Grid<Customer> grid;
    private final TextField nameField;
    private final Button addButton;

    @Autowired
    public CustomerView(FrontendCustomerService customerService) {
        this.customerService = customerService;
        this.grid = new Grid<>(Customer.class);
        this.nameField = new TextField("Name");
        this.addButton = new Button("Add Customer");

        addButton.addClickListener(e -> addCustomer());

        grid.setItems(customerService.getAllCustomers());

        add(nameField, addButton, grid);
    }

    private void addCustomer() {
        String name = nameField.getValue();
        Customer customer = new Customer();
        customer.setFirstName(name);
        customerService.createCustomer(customer);
        grid.setItems(customerService.getAllCustomers());
    }
}

