package views.customer.functionview.allsearchview;

import models.Customer;
import viewtemplate.CustomerTemplate;

import java.util.List;

public class SearchCustomerByAddressView extends CustomerTemplate {
    public SearchCustomerByAddressView() {

    }
    @Override
    protected void showBody() {
        System.out.println("Enter customer's address to search:");
        String address = scanner.nextLine();
        List<Customer> list = customerManagement.searchAddress(address);

        if (list == null) {
            System.out.println("The customer live in \"" + address + "\" does not exist!");
        } else {
            showCustomerList(list);
        }
    }
}
