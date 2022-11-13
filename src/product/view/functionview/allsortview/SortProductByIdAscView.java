package product.view.functionview.allsortview;

import product.Product;
import product.sort.ComparatorById;
import product.view.ProductTemplate;

import java.util.Collections;
import java.util.List;


public class SortProductByIdAscView extends ProductTemplate {
    public SortProductByIdAscView(){

    }
    @Override
    protected void showBody() {
        comparator = new ComparatorById();
        List<Product> products = productManagement.findAll();
        Collections.sort(products, comparator);
        showProduct(products);
    }
}
