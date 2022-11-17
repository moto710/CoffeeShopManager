package views.customer.functionview.allsortview;

import models.Customer;
import service.CustomerService;
import views.customer.sort.CompareCustomerDateCreate;
import viewtemplate.CustomerTemplate;

import java.util.List;

public class SortCustomerByDateCreateAscView extends CustomerTemplate {
    public SortCustomerByDateCreateAscView() {

    }
    @Override
    protected void showBody() {
        comparator = new CompareCustomerDateCreate();
        List<Customer> customers = CustomerService.findAll();
        customers.sort(comparator);
        showCustomerList(customers);
    }
}
