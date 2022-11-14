package customer.view.functionview.allsearchview;

import customer.Customer;
import customer.view.CustomerTemplate;

import java.util.List;

public class SearchCustomerByaddressView extends CustomerTemplate {
    public SearchCustomerByaddressView() {

    }
    @Override
    protected void showBody() {
        System.out.println("Enter customer's address to search:");
        String address = scanner.nextLine();
        List<Customer> list = customerManagement.searchAddress(address);

        if (list == null) {
            System.out.println("The customer live in \"" + address + "\" does not exist!");
        } else {
            showCustomer(list);
        }
    }
}
