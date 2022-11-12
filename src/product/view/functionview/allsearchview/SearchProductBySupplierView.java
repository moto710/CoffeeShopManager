package product.view.functionview.allsearchview;

import product.view.ProductTemplate;

public class SearchProductBySupplierView extends ProductTemplate {
    public SearchProductBySupplierView(){

    }
    @Override
    protected void showBody() {
        System.out.println("Enter product's supplier to search:");
        String supplier = scanner.nextLine();
        if (productManagement.searchSupplier(supplier) == null) {
            System.out.println("Don't have any product with this supplier: " + supplier);
        } else {
            showProduct(productManagement.searchSupplier(supplier));
        }
    }
}
