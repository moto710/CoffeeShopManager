package views.customer.functionview.allsortview;

import models.Customer;
import service.CustomerService;
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
        List<Customer> customers = CustomerService.findAll();
        customers.sort(comparator);
        Collections.reverse(customers);
        showCustomerList(customers);
    }
}
