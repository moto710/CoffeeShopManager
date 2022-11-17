package views.product.sort;

import models.Product;

import java.util.Comparator;

public class ComparatorByDateCreate implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        return o1.getDateCreate().compareTo(o2.getDateCreate());
    }
}
