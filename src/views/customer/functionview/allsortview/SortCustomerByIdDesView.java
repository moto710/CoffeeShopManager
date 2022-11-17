package views.customer.functionview.allsortview;

import models.Customer;
import views.customer.sort.CompareCustomerId;
import viewtemplate.CustomerTemplate;

import java.util.Collections;
import java.util.List;

public class SortCustomerByIdDesView extends CustomerTemplate {
    public SortCustomerByIdDesView() {

    }
    @Override
    protected void showBody() {
        comparator = new CompareCustomerId();
        List<Customer> customers = customerManagement.findAll();
        Collections.sort(customers, comparator);
        Collections.reverse(customers);
        showCustomer(customers);
    }
}
