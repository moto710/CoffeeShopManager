package views.customer.functionview.allsearchview;

import models.Customer;
import viewtemplate.CustomerTemplate;

import java.util.List;

public class SearchCustomerByaddressView extends CustomerTemplate {
    public SearchCustomerByaddressView() {

    }
    @Override
    protected void showBody() {
        System.out.println("Enter views.customer's address to search:");
        String address = scanner.nextLine();
        List<Customer> list = customerManagement.searchAddress(address);

        if (list == null) {
            System.out.println("The views.customer live in \"" + address + "\" does not exist!");
        } else {
            showCustomer(list);
        }
    }
}
