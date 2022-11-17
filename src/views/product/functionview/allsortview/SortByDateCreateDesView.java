package views.product.functionview.allsortview;

import models.Product;
import views.product.sort.ComparatorByDateCreate;
import viewtemplate.ProductTemplate;

import java.util.Collections;
import java.util.List;

public class SortByDateCreateDesView extends ProductTemplate {
    public SortByDateCreateDesView(){

    }
    @Override
    protected void showBody() {
        comparator = new ComparatorByDateCreate();
        List<Product> products = productManagement.findAll();
        Collections.sort(products, comparator);
        Collections.reverse(products);
        showProductList(products);
    }
}
