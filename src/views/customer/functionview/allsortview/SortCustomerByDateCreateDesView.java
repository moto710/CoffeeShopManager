package views.customer.functionview.allsortview;

import models.Customer;
import views.customer.sort.CompareCustomerDateCreate;
import viewtemplate.CustomerTemplate;

import java.util.Collections;
import java.util.List;

public class SortCustomerByDateCreateDesView extends CustomerTemplate {
    public SortCustomerByDateCreateDesView() {

    }
    @Override
    protected void showBody() {
        comparator = new CompareCustomerDateCreate();
        List<Customer> customers = customerManagement.findAll();
        Collections.sort(customers, comparator);
        Collections.reverse(customers);
        showCustomer(customers);
    }
}
