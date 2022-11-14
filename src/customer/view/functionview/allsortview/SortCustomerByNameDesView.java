package customer.view.functionview.allsortview;

import customer.Customer;
import customer.sort.CompareCustomerId;
import customer.sort.CompareCustomerName;
import customer.view.CustomerTemplate;

import java.util.Collections;
import java.util.List;

public class SortCustomerByNameDesView extends CustomerTemplate {
    public SortCustomerByNameDesView() {

    }
    @Override
    protected void showBody() {
        comparator = new CompareCustomerName();
        List<Customer> customers = customerManagement.findAll();
        Collections.sort(customers, comparator);
        Collections.reverse(customers);
        showCustomer(customers);
    }
}
