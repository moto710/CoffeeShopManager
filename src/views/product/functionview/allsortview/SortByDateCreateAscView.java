package views.product.functionview.allsortview;

import models.Product;
import views.product.sort.ComparatorByDateCreate;
import viewtemplate.ProductTemplate;

import java.util.Collections;
import java.util.List;

public class SortByDateCreateAscView extends ProductTemplate {
    public SortByDateCreateAscView(){

    }
    @Override
    protected void showBody() {
        comparator = new ComparatorByDateCreate();
        List<Product> products = productManagement.findAll();
        Collections.sort(products, comparator);
        showProductList(products);
    }
}
