package product.view.functionview.allsortview;

import product.sort.ComparatorById;
import product.view.ProductTemplate;

import static product.ProductManagement.printProduct;


public class SortProductByIdAscView extends ProductTemplate {
    public SortProductByIdAscView(){

    }
    @Override
    protected void showBody() {
        comparator = new ComparatorById();

        printProduct(productManagement.sortProduct(comparator));
    }
}
