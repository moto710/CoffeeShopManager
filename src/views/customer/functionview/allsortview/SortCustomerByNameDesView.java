package views.customer.functionview.allsortview;

import models.Customer;
import service.CustomerService;
import views.customer.sort.CompareCustomerName;
import viewtemplate.CustomerTemplate;

import java.util.Collections;
import java.util.List;

public class SortCustomerByNameDesView extends CustomerTemplate {
    public SortCustomerByNameDesView() {

    }
    @Override
    protected void showBody() {
        comparator = new CompareCustomerName();
        List<Customer> customers = CustomerService.findAll();
        customers.sort(comparator);
        Collections.reverse(customers);
        showCustomerList(customers);
    }
}
