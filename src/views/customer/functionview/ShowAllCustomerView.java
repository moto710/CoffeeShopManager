package views.customer.functionview;

import models.Customer;
import viewtemplate.CustomerTemplate;

import java.util.List;

public class ShowAllCustomerView extends CustomerTemplate {
    @Override
    protected void showBody() {
        List<Customer> customerList = customerManagement.findAll();
        showCustomerList(customerList);
    }
}
