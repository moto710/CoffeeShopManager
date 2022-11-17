package views.customer.functionview.allsortview;

import models.Customer;
import service.CustomerService;
import views.customer.sort.CompareCustomerEmail;
import viewtemplate.CustomerTemplate;

import java.util.Collections;
import java.util.List;

public class SortCustomerByEmailDesView extends CustomerTemplate {
    public SortCustomerByEmailDesView() {

    }
    @Override
    protected void showBody() {
        comparator = new CompareCustomerEmail();
        List<Customer> customers = CustomerService.findAll();
        customers.sort(comparator);
        Collections.reverse(customers);
        showCustomerList(customers);
    }
}
