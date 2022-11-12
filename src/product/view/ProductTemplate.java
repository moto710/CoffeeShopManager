package product.view;

import product.Product;
import product.ProductManagement;
import viewtemplate.ViewTemplate;

import java.util.Comparator;
import java.util.List;

public abstract class ProductTemplate extends ViewTemplate {
    protected static ProductManagement productManagement;

    protected Comparator<Product> comparator;
    protected ProductTemplate(){
        productManagement = new ProductManagement();
    }
    public static void showProduct(List<Product> productslist){
        for (Product product : productslist) {
            System.out.println(product);
        }
    }
}
