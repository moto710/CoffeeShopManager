package views.customer.functionview.allsearchview;

import models.Customer;
import viewtemplate.CustomerTemplate;


public class SearchCustomerByEmailView extends CustomerTemplate {
    public SearchCustomerByEmailView() {

    }
    @Override
    protected void showBody() {
        System.out.println("Enter customer's email to search:");
        String email = scanner.nextLine();
        showCustomer(customerManagement.searchEmail(email));
    }
}
