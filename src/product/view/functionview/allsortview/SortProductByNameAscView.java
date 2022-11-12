package product.view.functionview.allsortview;

import product.sort.ComparatorByName;
import product.view.ProductTemplate;

import java.util.Collections;

public class SortProductByNameAscView extends ProductTemplate {
    public SortProductByNameAscView(){

    }
    @Override
    protected void showBody() {
        comparator = new ComparatorByName();
        Collections.sort(productManagement.products(), comparator);
        showProduct(productManagement.products());
    }
}
