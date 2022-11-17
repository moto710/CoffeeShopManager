package views.customer.functionview.allsearchview;

import models.Customer;
import viewtemplate.CustomerTemplate;

public class SearchCustomerByPhoneView extends CustomerTemplate {
    public SearchCustomerByPhoneView() {

    }
    @Override
    protected void showBody() {
        System.out.println("Enter views.customer's phone number to search:");
        String phone = scanner.nextLine();
        Customer temp = customerManagement.searchPhone(phone);
        System.out.println(temp);
    }
}
