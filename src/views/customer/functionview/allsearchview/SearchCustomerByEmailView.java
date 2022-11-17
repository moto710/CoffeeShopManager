package views.customer.functionview.allsearchview;

import models.Customer;
import viewtemplate.CustomerTemplate;


public class SearchCustomerByEmailView extends CustomerTemplate {
    public SearchCustomerByEmailView() {

    }
    @Override
    protected void showBody() {
        System.out.println("Enter views.customer's email to search:");
        String email = scanner.nextLine();
        Customer temp = customerManagement.searchEmail(email);
        System.out.println(temp);
    }
}
