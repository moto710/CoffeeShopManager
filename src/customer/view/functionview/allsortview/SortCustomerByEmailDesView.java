package customer.view.functionview.allsortview;

import customer.Customer;
import customer.sort.CompareCustomerEmail;
import customer.sort.CompareCustomerId;
import customer.view.CustomerTemplate;

import java.util.Collections;
import java.util.List;

public class SortCustomerByEmailDesView extends CustomerTemplate {
    public SortCustomerByEmailDesView() {

    }
    @Override
    protected void showBody() {
        comparator = new CompareCustomerEmail();
        List<Customer> customers = customerManagement.findAll();
        Collections.sort(customers, comparator);
        Collections.reverse(customers);
        showCustomer(customers);
    }
}
