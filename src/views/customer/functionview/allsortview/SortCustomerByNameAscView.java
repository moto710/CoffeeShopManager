package views.customer.functionview.allsortview;

import models.Customer;
import views.customer.sort.CompareCustomerName;
import viewtemplate.CustomerTemplate;

import java.util.Collections;
import java.util.List;

public class SortCustomerByNameAscView extends CustomerTemplate {
    public SortCustomerByNameAscView() {

    }
    @Override
    protected void showBody() {
        comparator = new CompareCustomerName();
        List<Customer> customers = customerManagement.findAll();
        Collections.sort(customers, comparator);
        showCustomer(customers);
    }
}
