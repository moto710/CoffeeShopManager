package views.customer.functionview.allsortview;

import models.Customer;
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
        List<Customer> customers = customerManagement.findAll();
        Collections.sort(customers, comparator);
        showCustomer(customers);
    }
}
