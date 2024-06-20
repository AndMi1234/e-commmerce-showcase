package com.example.ecommerceplatform.frontend.view;

import com.example.ecommerceplatform.model.Product;
import com.example.ecommerceplatform.model.ProductCategory;
import com.example.ecommerceplatform.frontend.service.FrontendProductCategoryService;
import com.example.ecommerceplatform.frontend.service.FrontendProductService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.List;

@Route(value = "", layout = ShoppingView.class)
public class ProductCatalogView extends VerticalLayout {

    private final FrontendProductCategoryService categoryService;
    private final FrontendProductService productService;

    private HorizontalLayout categoryBar;
    private Div productContainer;

    @Autowired
    public ProductCatalogView(FrontendProductCategoryService categoryService, FrontendProductService productService) {
        this.categoryService = categoryService;
        this.productService = productService;

        categoryBar = new HorizontalLayout();
        productContainer = new Div();

        add(new H1("Product Catalog"), categoryBar, productContainer);
    }

    @PostConstruct
    private void init() {
        loadCategories();
    }

    private void loadCategories() {
        List<ProductCategory> categories = categoryService.getAllProductCategories();
        categoryBar.removeAll();
        for (ProductCategory category : categories) {
            Button categoryButton = new Button(category.getName());
            categoryButton.addClickListener(event -> loadProductsByCategory(category));
            categoryBar.add(categoryButton);
        }
    }

    private void loadProductsByCategory(ProductCategory category) {
        List<Product> products = productService.getProductsByCategory(category);
        productContainer.removeAll();
        for (Product product : products) {
            productContainer.add(createProductCard(product));
        }
    }

    private Div createProductCard(Product product) {
        Div card = new Div();
        card.addClassName("product-card");

        Span name = new Span(product.getName());
        Span price = new Span("$" + product.getPrice());
        Button detailsButton = new Button("Details", event -> showProductDetails(product));

        card.add(name, price, detailsButton);
        return card;
    }

    private void showProductDetails(Product product) {
        Dialog dialog = new Dialog();
        VerticalLayout dialogLayout = new VerticalLayout();
        dialog.add(dialogLayout);

        TextField nameField = new TextField("Name", product.getName());
        TextField priceField = new TextField("Price", String.valueOf(product.getPrice()));

        dialogLayout.add(nameField, priceField, new Button("Close", event -> dialog.close()));
        dialog.open();
    }
}