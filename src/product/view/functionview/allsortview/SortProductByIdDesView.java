package product.view.functionview.allsortview;

import product.sort.ComparatorById;
import product.view.ProductTemplate;

import java.util.Collections;

public class SortProductByIdDesView extends ProductTemplate {
    public SortProductByIdDesView(){

    }
    @Override
    protected void showBody() {
        comparator = new ComparatorById();
        Collections.sort(productManagement.products(), comparator);
        Collections.reverse(productManagement.products());
        showProduct(productManagement.products());
    }
}
