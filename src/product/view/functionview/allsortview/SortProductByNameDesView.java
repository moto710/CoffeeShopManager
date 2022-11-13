package product.view.functionview.allsortview;

import product.Product;
import product.sort.ComparatorByName;
import product.view.ProductTemplate;

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
        showProduct(products);
    }
}
