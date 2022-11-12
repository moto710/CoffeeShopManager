package product.view.functionview.allsortview;

import product.sort.ComparatorByDateCreate;
import product.view.ProductTemplate;

import java.util.Collections;

public class SortByDateCreateDesView extends ProductTemplate {
    public SortByDateCreateDesView(){

    }
    @Override
    protected void showBody() {
        comparator = new ComparatorByDateCreate();
        Collections.sort(productManagement.products(), comparator);
        Collections.reverse(productManagement.products());
        showProduct(productManagement.products());
    }
}
