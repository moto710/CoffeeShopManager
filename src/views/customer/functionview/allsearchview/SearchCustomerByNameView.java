package views.customer.functionview.allsearchview;

import models.Customer;
import viewtemplate.CustomerTemplate;

import java.util.List;

public class SearchCustomerByNameView extends CustomerTemplate {
    public SearchCustomerByNameView() {

    }
    @Override
    protected void showBody() {
        System.out.println("Enter customer's name to search:");
        String name = scanner.nextLine();
        List<Customer> list = customerManagement.searchName(name);

        if (list == null) {
            System.out.println("The product with name \"" + name + "\" does not exist!");
        } else {
            showCustomerList(list);
        }
    }
}
