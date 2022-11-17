package views.customer.functionview.allsortview;

import models.Customer;
import views.customer.sort.CompareCustomerEmail;
import viewtemplate.CustomerTemplate;

import java.util.Collections;
import java.util.List;

public class SortCustomerByEmailAscView extends CustomerTemplate {
    public SortCustomerByEmailAscView() {

    }
    @Override
    protected void showBody() {
        comparator = new CompareCustomerEmail();
        List<Customer> customers = customerManagement.findAll();
        Collections.sort(customers, comparator);
        showCustomer(customers);
    }
}
