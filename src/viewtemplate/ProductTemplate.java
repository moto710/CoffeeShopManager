package viewtemplate;

import models.Product;
import service.ProductService;

import java.util.Comparator;
import java.util.List;

public abstract class ProductTemplate extends ViewTemplate {
    public static ProductService productManagement;

    protected Comparator<Product> comparator;

    public ProductTemplate() {
        productManagement = new ProductService();
    }

    public static void showProductList(List<Product> productList) {
        System.out.println("========================================================================= PRODUCT LIST ====================================================================================\n");
        System.out.printf("|%-12s| |%-12s| | %-18s |  | %-16s | %-20s | %-15s |  | %-20s |  | %-20s |\n", "ID", "Name", "Inventory", "Unit", "Price", "Supplier", "Date Create", "Date Update" + "\n");
        for (Product product : productList) {
            System.out.printf("|%-12s| |%-12s| | %-18s |  | %-16s | %-20s | %-15s |  | %-20s |  | %-20s |\n", product.getId(), product.getName(), product.getInventory(), product.getUnit(), product.getPrice(), product.getSupplier(), product.getDateCreate(), product.getDateUpdate());
        }
        System.out.println("=========================================================================================================================================================================");
    }

    public static void showProduct(Product product) {
        System.out.println("========================================================================= PRODUCT ====================================================================================\n");
        System.out.printf("|%-12s| |%-12s| | %-18s |  | %-16s | %-20s | %-15s |  | %-20s |  | %-20s |\n", "ID", "Name", "Inventory", "Unit", "Price", "Supplier", "Date Create", "Date Update");
        System.out.println("");
        System.out.printf("|%-12s| |%-12s| | %-18s |  | %-16s | %-20s | %-15s |  | %-20s |  | %-20s |\n", product.getId(), product.getName(), product.getInventory(), product.getUnit(), product.getPrice(), product.getSupplier(), product.getDateCreate(), product.getDateUpdate());
        System.out.println("=========================================================================================================================================================================");
    }
}
