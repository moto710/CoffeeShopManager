package product.view.functionview.allsearchview;

import product.view.ProductTemplate;

public class SearchProductByUnitView extends ProductTemplate {
    public SearchProductByUnitView(){

    }
    @Override
    protected void showBody() {
        System.out.println("Enter product's unit to search:");
        String unit = scanner.nextLine();

        if (productManagement.searchUnit(unit) == null) {
            System.out.println("Maybe wrong unit: \"" + unit + "\". Please try again!");
        } else {
            showProduct(productManagement.searchUnit(unit));
        }
    }
}
