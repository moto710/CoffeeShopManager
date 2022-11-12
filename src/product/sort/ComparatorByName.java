package product.sort;

import product.Product;

import java.util.Comparator;

public class ComparatorByName implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        return o1.getName().compareToIgnoreCase(o2.getName());
    }
}
