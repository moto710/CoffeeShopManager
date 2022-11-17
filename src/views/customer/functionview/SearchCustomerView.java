package views.customer.functionview;

import views.customer.functionview.allsearchview.*;
import viewtemplate.CustomerTemplate;
import views.customer.view.functionview.allsearchview.*;

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
                    SearchCustomerByaddressView searchProductByUnitView = new SearchCustomerByaddressView();
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
        System.out.println("Search views.customer by:");
        System.out.println("------------------\n");
        System.out.println("1. ID:");
        System.out.println("2. Name:");
        System.out.println("3. email:");
        System.out.println("4. address:");
        System.out.println("5. phone:");
        System.out.println("0. Exit!");
        System.out.println("Enter your choice!");
        System.out.print("==> ");
    }
}
