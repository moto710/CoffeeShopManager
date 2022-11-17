package views.customer.functionview;

import views.customer.functionview.allsearchview.*;
import viewtemplate.CustomerTemplate;

public class SearchCustomerView extends CustomerTemplate {
    public SearchCustomerView() {

    }
    @Override
    protected void showBody() {
        boolean flag = true;
        do {
            menuSearchView();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    SearchCustomerByIdView searchProductByIdView = new SearchCustomerByIdView();
                    break;
                case 2:
                    SearchCustomerByNameView searchProductByNameView = new SearchCustomerByNameView();
                    break;
                case 3:
                    SearchCustomerByEmailView searchProductByInventoryView = new SearchCustomerByEmailView();
                    break;
                case 4:
                    SearchCustomerByAddressView searchProductByUnitView = new SearchCustomerByAddressView();
                    break;
                case 5:
                    SearchCustomerByPhoneView searchProductByEntryPriceView = new SearchCustomerByPhoneView();
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
        System.out.println("=========== Search customer by =============");
        System.out.println("=                                          =");
        System.out.println("=                1. ID                     =");
        System.out.println("=                2. Name                   =");
        System.out.println("=                3. Email                  =");
        System.out.println("=                4. Address                =");
        System.out.println("=                5. Phone                  =");
        System.out.println("=                0. Exit!                  =");
        System.out.println("=                                          =");
        System.out.println("============================================");
        System.out.println("Choose function to show!");
        System.out.print("===>");
    }
}
