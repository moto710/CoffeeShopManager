package views.product.functionview.allsortview;

import models.Product;
import views.product.sort.ComparatorById;
import viewtemplate.ProductTemplate;

import java.util.Collections;
import java.util.List;


public class SortProductByIdAscView extends ProductTemplate {
    public SortProductByIdAscView(){

    }
    @Override
    protected void showBody() {
        comparator = new ComparatorById();
        List<Product> products = productManagement.findAll();
        Collections.sort(products, comparator);
        showProductList(products);
    }
}
