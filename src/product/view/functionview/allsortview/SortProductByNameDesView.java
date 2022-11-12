package product.view.functionview.allsortview;

import product.sort.ComparatorByName;
import product.view.ProductTemplate;

import java.util.Collections;

public class SortProductByNameDesView extends ProductTemplate {
    public SortProductByNameDesView(){

    }
    @Override
    protected void showBody() {
        comparator = new ComparatorByName();
        Collections.sort(productManagement.products(), comparator);
        Collections.reverse(productManagement.products());
        showProduct(productManagement.products());
    }
}
