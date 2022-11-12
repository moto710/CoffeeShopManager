package product.view.functionview.allsortview;

import product.sort.ComparatorById;
import product.view.ProductTemplate;

import java.util.Collections;


public class SortProductByIdAscView extends ProductTemplate {
    public SortProductByIdAscView(){

    }
    @Override
    protected void showBody() {
        comparator = new ComparatorById();
        Collections.sort(productManagement.products(), comparator);
        showProduct(productManagement.products());
    }
}
