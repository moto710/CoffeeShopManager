package product.view.functionview.allsortview;

import product.Product;
import product.sort.ComparatorByName;
import product.view.ProductTemplate;

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
        showProduct(products);
    }
}
