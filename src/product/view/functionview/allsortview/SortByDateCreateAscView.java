package product.view.functionview.allsortview;

import product.Product;
import product.sort.ComparatorByDateCreate;
import product.view.ProductTemplate;

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
        showProduct(products);
    }
}
