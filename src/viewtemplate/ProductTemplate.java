package viewtemplate;

import models.Product;
import service.ProductService;
import viewtemplate.ViewTemplate;

import java.util.Comparator;
import java.util.List;

public abstract class ProductTemplate extends ViewTemplate {
    public static ProductService productManagement;

    protected Comparator<Product> comparator;
    public ProductTemplate(){
        productManagement = new ProductService();
    }
    public static void showProduct(List<Product> productslist){
        for (Product product : productslist) {
            System.out.println(product.toString());
        }
    }
}
