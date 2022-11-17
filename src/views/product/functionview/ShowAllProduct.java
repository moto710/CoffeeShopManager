package views.product.functionview;

import models.Product;
import service.ProductService;
import viewtemplate.ProductTemplate;

import java.util.List;

public class ShowAllProduct extends ProductTemplate {
    @Override
    protected void showBody() {
        List<Product> products = ProductService.findAll();
        showProductList(products);
    }
}
