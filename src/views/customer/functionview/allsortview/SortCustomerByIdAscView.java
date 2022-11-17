package views.customer.functionview.allsortview;

import models.Customer;
import service.CustomerService;
import views.customer.sort.CompareCustomerId;
import viewtemplate.CustomerTemplate;

import java.util.Collections;
import java.util.List;

public class SortCustomerByIdAscView extends CustomerTemplate {
    public SortCustomerByIdAscView() {

    }
    @Override
    protected void showBody() {
        comparator = new CompareCustomerId();
        List<Customer> customers = CustomerService.findAll();
        customers.sort(comparator);
        showCustomerList(customers);
    }
}
