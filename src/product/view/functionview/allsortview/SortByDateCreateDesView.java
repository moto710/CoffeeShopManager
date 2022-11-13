package product.view.functionview.allsortview;

import product.Product;
import product.sort.ComparatorByDateCreate;
import product.view.ProductTemplate;

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
        showProduct(products);
    }
}
