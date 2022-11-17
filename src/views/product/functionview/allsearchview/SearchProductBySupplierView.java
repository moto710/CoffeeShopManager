package views.product.functionview.allsearchview;

import viewtemplate.ProductTemplate;

public class SearchProductBySupplierView extends ProductTemplate {
    public SearchProductBySupplierView(){

    }
    @Override
    protected void showBody() {
        System.out.println("Enter views.product's supplier to search:");
        String supplier = scanner.nextLine();
        if (productManagement.searchSupplier(supplier) == null) {
            System.out.println("Don't have any views.product with this supplier: " + supplier);
        } else {
            showProduct(productManagement.searchSupplier(supplier));
        }
    }
}
