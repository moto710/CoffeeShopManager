package views.customer.functionview.allsortview;

import models.Customer;
import service.CustomerService;
import views.customer.sort.CompareCustomerEmail;
import viewtemplate.CustomerTemplate;

import java.util.List;

public class SortCustomerByEmailAscView extends CustomerTemplate {
    public SortCustomerByEmailAscView() {

    }
    @Override
    protected void showBody() {
        comparator = new CompareCustomerEmail();
        List<Customer> customers = CustomerService.findAll();
        customers.sort(comparator);
        showCustomerList(customers);
    }
}
