package com.example.ecommerceplatform.frontend.view;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouterLink;

public class ShoppingView extends AppLayout {

    public ShoppingView() {
        createHeader();
        createDrawer();
    }

    private void createHeader() {
        // Create a header with your app title or logo
        addToNavbar(new Button("Ecommerce Showcase"));
    }

    private void createDrawer() {
        // Add navigation links to the drawer
        RouterLink productCatalogLink = new RouterLink("Product Catalog", ProductCatalogView.class);
        addToDrawer(new VerticalLayout(productCatalogLink));
    }
}
