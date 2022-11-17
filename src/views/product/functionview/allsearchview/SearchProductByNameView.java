package views.product.functionview.allsearchview;

import models.Product;
import viewtemplate.ProductTemplate;

import java.util.List;

public class SearchProductByNameView extends ProductTemplate {
    public SearchProductByNameView(){

    }
    @Override
    protected void showBody() {
        System.out.println("Enter product's name to search:");
        String name = scanner.nextLine();
        List<Product> list = productManagement.searchName(name);

        if (list == null) {
            System.out.println("The product with name \"" + name + "\" does not exist!");
        } else {
            showProductList(list);
        }
    }
}
