package views.product.functionview.allsortview;

import models.Product;
import views.product.sort.ComparatorByName;
import viewtemplate.ProductTemplate;

import java.util.Collections;
import java.util.List;

public class SortProductByNameAscView extends ProductTemplate {
    public SortProductByNameAscView(){

    }
    @Override
    protected void showBody() {
        comparator = new ComparatorByName();
        List<Product> products = productManagement.findAll();
        Collections.sort(products, comparator);
        showProductList(products);
    }
}
