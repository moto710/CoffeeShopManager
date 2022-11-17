package views.product.functionview;

import views.product.functionview.allsearchview.*;
import viewtemplate.ProductTemplate;

public class SearchProductView extends ProductTemplate {
    public SearchProductView(){

    }
    @Override
    protected void showBody() {
        boolean flag = true;
        do {
            menuSearchView();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    SearchProductByIdView searchProductByIdView = new SearchProductByIdView();
                    break;
                case 2:
                    SearchProductByNameView searchProductByNameView = new SearchProductByNameView();
                    break;
                case 3:
                    SearchProductByInventoryView searchProductByInventoryView = new SearchProductByInventoryView();
                    break;
                case 4:
                    SearchProductByUnitView searchProductByUnitView = new SearchProductByUnitView();
                    break;
                case 5:
                    SearchProductByPriceView searchProductByEntryPriceView = new SearchProductByPriceView();
                    break;
                case 6:
                    SearchProductBySupplierView searchProductBySupplierView = new SearchProductBySupplierView();
                    break;
                case 0:
                    flag = false;
                    break;
                default:
                    System.out.println("Wrong input, enter again!");
                    break;
            }
        } while (flag);
    }
    protected void menuSearchView() {
        System.out.println("============== Search product by ================");
        System.out.println("=                                               =");
        System.out.println("=                 1. ID                         =");
        System.out.println("=                 2. Name                       =");
        System.out.println("=                 3. Inventory                  =");
        System.out.println("=                 4. Unit                       =");
        System.out.println("=                 5. Price                      =");
        System.out.println("=                 6. Supplier                   =");
        System.out.println("=                 0. Exit!                      =");
        System.out.println("=                                               =");
        System.out.println("=================================================");
        System.out.println("Choose function to show!");
        System.out.print("===>");
    }
}
