package product.view.functionview.allsortview;

import product.sort.ComparatorByDateCreate;
import product.view.ProductTemplate;

import java.util.Collections;

public class SortByDateCreateAscView extends ProductTemplate {
    public SortByDateCreateAscView(){

    }
    @Override
    protected void showBody() {
        comparator = new ComparatorByDateCreate();
        Collections.sort( productManagement.products(), comparator);
        showProduct(productManagement.products());
    }
}
