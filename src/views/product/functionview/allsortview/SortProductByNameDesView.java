package views.product.functionview.allsortview;

import models.Product;
import views.product.sort.ComparatorByName;
import viewtemplate.ProductTemplate;

import java.util.Collections;
import java.util.List;

public class SortProductByNameDesView extends ProductTemplate {
    public SortProductByNameDesView(){

    }
    @Override
    protected void showBody() {
        comparator = new ComparatorByName();
        List<Product> products = productManagement.findAll();
        Collections.sort(products, comparator);
        Collections.reverse(products);
        showProductList(products);
    }
}
