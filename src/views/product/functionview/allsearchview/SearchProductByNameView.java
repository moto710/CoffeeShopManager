package views.product.functionview.allsearchview;

import models.Product;
import viewtemplate.ProductTemplate;

import java.util.List;

public class SearchProductByNameView extends ProductTemplate {
    public SearchProductByNameView(){

    }
    @Override
    protected void showBody() {
        System.out.println("Enter views.product's name to search:");
        String name = scanner.nextLine();
        List<Product> list = productManagement.searchName(name);

        if (list == null) {
            System.out.println("The views.product with name \"" + name + "\" does not exist!");
        } else {
            showProduct(list);
        }
    }
}
